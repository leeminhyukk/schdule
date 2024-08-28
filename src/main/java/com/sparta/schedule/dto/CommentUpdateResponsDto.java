package com.sparta.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentUpdateResponsDto {
    private final String contents;
    private final String userName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
}
