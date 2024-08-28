package com.sparta.schedule.dto.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class MemberUpdateResponseDto {
    private final String name;
    private final String email;
    private final LocalDateTime modifiedAt;

    public MemberUpdateResponseDto(String name, String email){
        this.name = name;
        this.email =email;
        this.modifiedAt = LocalDateTime.now();
    }

}
