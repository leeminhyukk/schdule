package com.sparta.schedule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 엔티티 어노테이션, 가져다 써야하니 Getter
//@Table(name = "schedule")
@Entity
@Getter
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String userName;
    private String contents;
    // 로컬에서 가져오는 시간. 생성,수정된 시간
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    //생성자 필수로 입력하는값 작성자(userName),제목(title),내용(contents)
    public Schedule(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        //등록한 시간
        this.createAt = LocalDateTime.now();
    }

    // 수정 메서드
    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
        //수정한 시간
        this.modifiedAt = LocalDateTime.now();
    }


}
