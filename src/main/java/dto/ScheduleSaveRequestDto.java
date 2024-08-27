package dto;

import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {
    private String userName;
    private String title;
    private String contents;
}
