package com.sparta.schedule.dto;


import lombok.Getter;

import java.time.LocalDateTime;

// Local 시간을 Dto 에도 담으려고 했으나 Schedule 이 생성되는 시점과 혹시라도 Dto로 반환하는 시점이 다르면 오류가 날까봐 보류.
@Getter
public class ScheduleSaveResponseDto {
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;


    public ScheduleSaveResponseDto(String userName, String title, String contents){
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createAt = LocalDateTime.now();


    }

}
