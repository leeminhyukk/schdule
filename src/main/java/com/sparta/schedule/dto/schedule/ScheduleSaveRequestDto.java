package com.sparta.schedule.dto.schedule;

import lombok.Getter;


// 등록 생성자 필수값 = 필드값
@Getter
public class ScheduleSaveRequestDto {
    private String userName;
    private String title;
    private String contents;
}
