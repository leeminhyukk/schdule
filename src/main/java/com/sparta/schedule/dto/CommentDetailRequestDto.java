package com.sparta.schedule.dto;

import lombok.Getter;

//댓글 단건 조회 요청
@Getter
public class CommentDetailRequestDto {
    private String contents;
    private String userName;

}
