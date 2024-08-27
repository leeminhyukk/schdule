package com.sparta.schedule.dto;

import lombok.Getter;


// 생성자 필수 요구값을 필드값으로 넣었습니다.
@Getter
public class ScheduleSaveRequestDto {
    private String userName;
    private String title;
    private String contents;
}
