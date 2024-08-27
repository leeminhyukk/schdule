package com.sparta.schedule.controller;

import com.sparta.schedule.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sparta.schedule.service.ScheduleService;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 등록
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponseDto> saveSchedule(@RequestBody ScheduleSaveRequestDto scheduleSaveRequestDto){
        return ResponseEntity.ok(scheduleService.saveSchedule(scheduleSaveRequestDto));
        // 위에서 선언된 서비스 객체에 일정등록 메서드 적용하고, 생성된 Dto 반환
        // 반환타입 Dto 앞에 ResponseEntity 가 없이 만들었다면
        // return scheduleService.saveSchedule(scheduleSaveRequestDto);

    }

    // 단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleDetailResponseDto> getSchedule (@PathVariable Long scheduleId){
        return ResponseEntity.ok(scheduleService.getSchedule(scheduleId));
    }

    // 수정
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponseDto> updateSchedule (@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequestDto scheduleUpdateRequestDto){
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId,scheduleUpdateRequestDto ));
    }
}
