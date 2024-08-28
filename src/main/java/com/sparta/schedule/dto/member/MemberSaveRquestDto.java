package com.sparta.schedule.dto.member;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberSaveRquestDto {
    private String name;
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
