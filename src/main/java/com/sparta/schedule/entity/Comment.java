package com.sparta.schedule.entity;

import com.sparta.schedule.dto.CommentsaveRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 댓글 하나에 일정이 여러개 일 순 없다. 따라서 댓글이 N 일정이 1 관계 복수니까 comments
@Table(name="comments")
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

    // 생성자 Dto 의 값을 가져와서 생성. service 에서 적용합니다.
    public Comment(String contents, String userName){
        this.contents = contents;
        this.createAt = LocalDateTime.now();
        this.userName = userName;
    }


    //양방향 처럼 설정. mappedBy 를 사용할 수 없다.
    @ManyToOne
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    private Schedule schedule;


}
