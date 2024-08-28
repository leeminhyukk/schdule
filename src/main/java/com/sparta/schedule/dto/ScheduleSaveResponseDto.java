package com.sparta.schedule.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

// 필드값을 모두 넣어서 생성자 만들도록 설정.
@Getter
@AllArgsConstructor
public class ScheduleSaveResponseDto {
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;




}
