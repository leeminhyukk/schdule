package dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleSaveResponseDto {
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
}
