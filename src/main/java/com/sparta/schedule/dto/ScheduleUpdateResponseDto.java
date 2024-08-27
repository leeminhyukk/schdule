package com.sparta.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
    // 이렇게 하면 수정할 때 생성 시간도 수정될까봐 걱정했는데, 다행히 생성시간은 그대로 입니다!


}
