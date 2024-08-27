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
        // Dto 넣어서 댓글 만들고, 일정에 댓글 등록
        Comment comment = new Comment(commentsaveRequestDto.getContents(), commentsaveRequestDto.getUserName());
        // 적용된 값 저장.
        Comment savedComment = commentRepository.save(comment);
        schedule.addComment(savedComment);
        scheduleRepository.save(schedule);


        // 저장된 값을 객체로 지정하고, 그 객체의 정보를 Dto 에 담아서 반환.
        return new CommentSaveResponseDto(savedComment.getContents(), savedComment.getUserName(), savedComment.getCreateAt());

    }

    //단건 조회
    public CommentDetailResponseDto getComment(Long scheduleId, Long commentsId) {

        // 조회하고 싶은 메모 있는지 확인.
        Comment comment = commentRepository.findById(commentsId).orElseThrow(() -> new NullPointerException("해당 메모는 존재하지 않습니다."));
        return new CommentDetailResponseDto(comment.getContents(),comment.getUserName(),comment.getCreateAt(),comment.getModifiedAt());
    }

    //전체 조회
    public List<CommentSimpleResponseDto> getComments(Long scheduleId) {
        //스케쥴이 존재하는지 먼저 확인.
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("해당 스케쥴이 존재하지 않습니다."));

        // 레퍼지토리에서 댓글을 전부 다 찾기. = List 로 만들고 for 문 돌려서 확인.
        // 댓글의 모든 dto 를 뽑아서 List 에 담아서 반환.
        List<Comment> comments = commentRepository.findAll();
        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : comments){
            CommentSimpleResponseDto dto = new CommentSimpleResponseDto(comment.getContents(),comment.getUserName(),comment.getCreateAt(),comment.getModifiedAt());
            dtoList.add(dto);
        }
        return dtoList;

    }
}
