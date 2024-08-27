package com.sparta.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//수정 수정이라서 수정시간도 필드에 추가.
@Getter
@AllArgsConstructor
public class ScheduleUpdateResponseDto {
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;



}
