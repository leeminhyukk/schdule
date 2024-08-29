package com.sparta.schedule.dto.schedule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

//단건 조회 (상세 조회)
@Getter

public class ScheduleDetailResponseDto {

    private Long id;
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;


    // 생성자 파라미터로 creatAt,modifiedAt 을 받도록 수정.
    public ScheduleDetailResponseDto(String userName, String title, String contents, LocalDateTime createAt, LocalDateTime modifiedAt, Long id) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.id = id;
        // this.createAt = LocalDateTime.now();

    }
}
