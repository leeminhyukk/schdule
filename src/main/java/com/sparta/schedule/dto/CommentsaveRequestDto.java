package com.sparta.schedule.dto;

import lombok.Getter;

// 댓글 등록(저장) 요청
@Getter
public class CommentsaveRequestDto {
    private String contents;
    private String userName;
}
