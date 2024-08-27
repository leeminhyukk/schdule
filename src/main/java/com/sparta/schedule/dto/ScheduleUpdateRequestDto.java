package com.sparta.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {
    // 수정을 원하는 값을 Dto 의 필드에 넣었습니다. 수정시간은 entity 에서 적용시킬게요!
    private String title;
    private String contents;

}
