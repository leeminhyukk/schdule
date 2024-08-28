package com.sparta.schedule.dto.comment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class CommentSimpleResponseDto {
    private final String contents;
    private final String userName;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;
    private final Long id;
}
