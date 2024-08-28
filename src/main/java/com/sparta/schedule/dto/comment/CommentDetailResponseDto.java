package com.sparta.schedule.dto.comment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

//댓글 단건 조회 응답
@Getter
@RequiredArgsConstructor
public class CommentDetailResponseDto {
    private final String contents;
    private final String userName;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;
    private final Long Id;



}
