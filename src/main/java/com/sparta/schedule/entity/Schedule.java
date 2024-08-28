package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// 엔티티 어노테이션, 가져다 써야하니 Getter
@Table(name = "schedule")
@Entity
@Getter
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;
    private String userName;
    private String contents;
    // 로컬에서 가져오는 시간. 생성,수정된 시간
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    // 하나의 일정에 여러개의 댓글이 달릴 수 있으니 리스트 생성
    // 리스트는 Only Entity 데이터 베이스에 리스트 방식으로 적용되는건 아니다
    // mappedBy 안에 schedule 은 Comment 필드에 있는 값이다.
    // 일정을 삭제할 때, 댓글도 함께 삭제되도록 설정. cascade = CascadeType.PERSIST, orphanRemoval = true
    @OneToMany(mappedBy = "schedule",cascade = CascadeType.PERSIST, orphanRemoval = true)
    //@JoinColumn(name = "schedule_id") // comment 테이블에 schedule_id 컬럼
    private List<Comment> commentList = new ArrayList<>();

    //N대M 양방향 2주차 10강
    @OneToMany(mappedBy = "schedule")
    private List<Member> memberList = new ArrayList<>();


    //생성자 필수로 입력하는값 작성자(userName),제목(title),내용(contents)
    public Schedule(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        //등록한 시간
        this.createAt = LocalDateTime.now();
        this.modifiedAt =LocalDateTime.now();
    }

    // 수정 메서드
    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
        //수정한 시간
        this.modifiedAt = LocalDateTime.now();
    }


    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }
}
