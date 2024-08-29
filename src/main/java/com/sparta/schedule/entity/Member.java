package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Member {

    //유저는 유저명, 이메일, 작성일, 수정일 필드를 갖고 있습니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "member")
    private List<MemberSchedule> memberSchedule = new ArrayList<>();

    public Member(String name, String email){
        this.name = name;
        this.email = email;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }


    //유저 수정 메서드
    public void update(String name, String email) {
        this.name =name;
        this.email =email;
        this.modifiedAt = LocalDateTime.now();
    }



}

