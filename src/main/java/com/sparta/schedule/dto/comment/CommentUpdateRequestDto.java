package com.sparta.schedule.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
//댓글 수정.
//내용,유저명,수정일을 받습니다.

@Getter
@AllArgsConstructor
public class CommentUpdateRequestDto {
    private String contents;
    private String userName;
    private LocalDateTime modifiedAt;
}
