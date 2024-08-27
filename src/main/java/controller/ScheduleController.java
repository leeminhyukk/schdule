package controller;

import dto.ScheduleSaveRequestDto;
import dto.ScheduleSaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.ScheduleService;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 등록
    @PostMapping("/schedules/")
    public ResponseEntity<ScheduleSaveResponseDto> saveSchecule(@RequestBody ScheduleSaveRequestDto scheduleSaveRequestDto){

    }
}
