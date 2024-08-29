package com.sparta.schedule.dto.comment;

import com.sparta.schedule.entity.Schedule;
import lombok.Getter;

// 댓글 등록(저장) 요청
@Getter
public class CommentsaveRequestDto {
    private String contents;
    private String userName;
    private Schedule schedule;
}
