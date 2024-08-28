package com.sparta.schedule.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

// 댓글 등록(저장) 응답
@Getter
@AllArgsConstructor
public class CommentSaveResponseDto {
    // 댓글은 댓글 내용, 작성일, 수정일, 작성 유저명 필드를 갖고 있습니다.
    private final String contents;
    private final String userName;
    private final LocalDateTime createdAt;
    private final Long id;

}
