package com.sparta.schedule.service;

import com.sparta.schedule.dto.*;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.CommentRepository;
import com.sparta.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    //댓글 등록
    @Transactional
    public CommentSaveResponseDto saveComment(Long scheduleId, CommentsaveRequestDto commentsaveRequestDto) {
        //댓글을 달고 싶은 일정이 있는지 확인.
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("해당 스케쥴이 존재하지 않습니다."));
        // Dto 의 값으로 댓글을 만든다.
        Comment comment = new Comment(commentsaveRequestDto.getContents(), commentsaveRequestDto.getUserName());
        // 적용된 값 저장.
        Comment savedComment = commentRepository.save(comment);
        schedule.addComment(savedComment);
        scheduleRepository.save(schedule);


        // 저장된 값을 객체로 지정하고, 그 객체의 정보를 Dto 에 담아서 반환.
        return new CommentSaveResponseDto(savedComment.getContents(), savedComment.getUserName(), savedComment.getCreateAt(),savedComment.getId());

    }

    //단건 조회
    public CommentDetailResponseDto getComment(Long scheduleId, Long commentsId) {
        //일정, 댓글이 있는지 각 Id 로 확인
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("일정이 존재하지 않습니다."));
        Comment findcomment = commentRepository.findById(commentsId).orElseThrow(() -> new NullPointerException("메모가 존재하지 않습니다."));
        //일정에 입력된 댓글인지 확인
        List<Comment> comments = schedule.getCommentList();
        for (Comment comment : comments){
            if(comment.getId().equals(commentsId)){
                findcomment = comment;
            }
        }
        // 시간이 된다면 돌아와서 예외처리 추가하겠습니다. 해당 일정에 등록된 댓글이 아닐경우!
        //comment 에 scheduleId 를 담아야합니다.
        return new CommentDetailResponseDto(findcomment.getContents(),findcomment.getUserName(),findcomment.getCreateAt(),findcomment.getModifiedAt(),findcomment.getId());
    }

    //전체 조회
    public List<CommentSimpleResponseDto> getComments(Long scheduleId) {
        //스케쥴이 존재하는지 먼저 확인.
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("해당 스케쥴이 존재하지 않습니다."));

        // 레퍼지토리에서 댓글을 전부 다 찾기. = List 로 만들고 for 문 돌려서 확인.
        // 모든 댓글의 정보를 Dto 에 담아서 반환
        // List<Comment> comments = commentRepository.findAll(); = 수정전 전체 조회
        // scheduleId를 이용해 comment 에 scheduleId 를 넣어서 반환
        // ScheduleID 별 조회가 아니라 아예 전체 조회일 경우. 수정
        List<Comment> comments = schedule.getCommentList();
        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : comments){
            CommentSimpleResponseDto dto = new CommentSimpleResponseDto(comment.getContents(),comment.getUserName(),comment.getCreateAt(),comment.getModifiedAt(),comment.getId());
            dtoList.add(dto);
        }
        return dtoList;

    }

    @Transactional
    // 수정
    public CommentUpdateResponsDto updateComment(Long scheduleId, Long commentsId, CommentUpdateRequestDto commentUpdateRequestDto) {
        //일정,댓글 확인 단건 조회 그대로 사용.
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("일정이 존재하지 않습니다."));
        Comment findcomment = commentRepository.findById(commentsId).orElseThrow(() -> new NullPointerException("메모가 존재하지 않습니다."));
        //일정에 입력된 댓글인지 확인
        List<Comment> comments = schedule.getCommentList();
        for (Comment comment : comments){
            if(comment.getId().equals(commentsId)){
                findcomment = comment;
            }
        }

        //엔티티에 메서드를 만들고 사용해서 수정.
        findcomment.update(commentUpdateRequestDto.getContents(),commentUpdateRequestDto.getUserName());
        // 수정된 객체의 정보를 Dto 에 담아서 반환
        return new CommentUpdateResponsDto(findcomment.getContents(),findcomment.getUserName(),findcomment.getCreateAt(),findcomment.getModifiedAt());
    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long scheduleId, Long commentsId) {
        //일정,댓글 확인 단건 조회 그대로 사용.
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("일정이 존재하지 않습니다."));
        Comment findcomment = commentRepository.findById(commentsId).orElseThrow(() -> new NullPointerException("메모가 존재하지 않습니다."));
        //일정에 입력된 댓글인지 확인
        List<Comment> comments = schedule.getCommentList();
        for (Comment comment : comments){
            if(comment.getId().equals(commentsId)){
                findcomment = comment;
            }
        }
        // 만들어져있는 메서드 사용해서 삭제
        commentRepository.delete(findcomment);
    }
}
