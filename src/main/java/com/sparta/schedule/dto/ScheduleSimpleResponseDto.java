package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ScheduleSimpleResponseDto {
    private final Long id;
    private final String userName;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;


    public ScheduleSimpleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.userName = schedule.getUserName();
        this.contents = schedule.getContents();
        this.createAt = schedule.getCreateAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
