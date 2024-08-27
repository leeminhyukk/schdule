package com.sparta.schedule.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

//단건 조회 (상세 조회)
@Getter
@RequiredArgsConstructor
public class ScheduleDetailResponseDto {
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;


    public ScheduleDetailResponseDto(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createAt = LocalDateTime.now();

    }
}
