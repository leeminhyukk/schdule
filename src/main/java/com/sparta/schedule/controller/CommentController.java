package com.sparta.schedule.controller;

import com.sparta.schedule.dto.CommentsaveRequestDto;
import com.sparta.schedule.dto.CommentsaveResponseDto;
import com.sparta.schedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 등록
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentsaveResponseDto> saveComment(@PathVariable Long scheduleId, @RequestBody CommentsaveRequestDto commentsaveRequestDto){
        return ResponseEntity.ok(commentService.saveComment(scheduleId, commentsaveRequestDto));
    }
}
