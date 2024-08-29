package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// 댓글 하나에 일정이 여러개 일 순 없다. 따라서 댓글이 N 일정이 1 관계 복수니까 comments
@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 댓글 구성 = 내용 contents , 작성일 createAt, 수정일 modifiedAt, 작성 유저명 userName
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private String userName;

    //양방향 처럼 설정. mappedBy 를 사용할 수 없다.
    // ManyToOne 의 기본값은 EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    @Setter
    @JoinColumn(name = "scheduel_id")
    private Schedule schedule;



    // 생성자 Dto 의 값을 가져와서 생성. service 에서 적용합니다.
    public Comment(String contents, String userName){
        this.contents = contents;
        this.createAt = LocalDateTime.now();
        this.userName = userName;
    }




    //수정 시간을 메서드 사용시 입력합니다.
    public void update(String contents, String userName) {
        this.contents = contents;
        this.userName = userName;
        this.modifiedAt = LocalDateTime.now();
    }
}
