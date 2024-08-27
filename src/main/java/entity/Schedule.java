package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

// 엔티티 어노테이션, 가져다 써야하니 Getter, 생성자 따로 만들지않아도 쓸 수 있는 어노테이션(습관)
@Entity
@Getter
@NoArgsConstructor
public class Schedule {
    // ID 를 자동으로 생성하게끔 설정.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String userName;
    private String contents;
    // 로컬에서 가져오는 시간. 생성,수정된 시간
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    //생성자 필수로 입력하는값 작성자(userName),제목(title),내용(contents)
    public Schedule(String userName, String title, String contents ){
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createAt = LocalDateTime.now();
    }


}
