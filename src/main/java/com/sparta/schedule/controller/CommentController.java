package com.sparta.schedule.controller;

import com.sparta.schedule.dto.*;
import com.sparta.schedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 등록(저장)
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(@PathVariable Long scheduleId, @RequestBody CommentsaveRequestDto commentsaveRequestDto){
        return ResponseEntity.ok(commentService.saveComment(scheduleId, commentsaveRequestDto));
    }

    //댓글 단건 조회
    // ScheduleId 를생략하고 싶었으나,
    // 그냥 몇번째 댓글이 아닌 각 게시물의 몇 번째 댓글인지 확인하기 위해 다시 추가했습니다.
    // Sql 제대로 공부할 것!!
    @GetMapping("/schedules/{scheduleId}/comments/{commentsId}")
    public ResponseEntity<CommentDetailResponseDto> getComment(@PathVariable Long scheduleId, @PathVariable Long commentsId){
        return ResponseEntity.ok(commentService.getComment(scheduleId,commentsId));
    }

    //댓글 전체 조회
    //게시물 Id 별 전체 조회.
    //전체에서 조회하는거라서 List
    @GetMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<List<CommentSimpleResponseDto>> getComments(@PathVariable Long scheduleId){
        return ResponseEntity.ok(commentService.getComments(scheduleId));
    }

}
