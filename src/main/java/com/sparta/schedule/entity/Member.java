package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "schedule")
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

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

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


    // 유저를 저장,단건 조회, 전체 조회,삭제 할 수 있습니다.
    // 일정은 이제 작성 유저명 필드 대신 유저 고유 식별자 필드를 가집니다 (userName -> name(user 의 이름))
    // 일정을 작성한 유저는 추가로 일정 담당 유저들을 배치할 수 있습니다.
    // 유저와 일정은 N:M 관계 Many To Many !!!!!!
    // 1. 일정마다 일정을 만든 유저가 있다.(작성자)
    // 2. 일정에 담당 유저를 추가할 수 있다. (작성자 + 담당자(복수선택 가능))
    // 3. 엔티티는 유저, 일정, 댓글 이 셋의 관계는 일정에서 겹친다.
    // 4. 일정 대 유저 = 일정 oneToMany 유저
    // 5. 일정 대 댓글 = 일정 OneToMany 댓글
    // 6. 유저 Many ... one 일정 one ... Many 댓글 이라고 생각하고 시작.
    // 7. 이미 일정과 댓글 부분은 완료했음.
}

