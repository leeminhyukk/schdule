package com.sparta.schedule.service;

import com.sparta.schedule.dto.CommentsaveRequestDto;
import com.sparta.schedule.dto.CommentSaveResponseDto;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.CommentRepository;
import com.sparta.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        schedule.addComment(comment);
        // 적용된 값 저장.
        Schedule savedSchedule = scheduleRepository.save(schedule);
        Comment savedComment = commentRepository.save(comment);

        // 저장된 값을 객체로 지정하고, 그 객체의 정보를 Dto 에 담아서 반환.
        return new CommentSaveResponseDto(savedComment.getContents(),savedComment.getUserName(),savedComment.getCreateAt());

    }
}
