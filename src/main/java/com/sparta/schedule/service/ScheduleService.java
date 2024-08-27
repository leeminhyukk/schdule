package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleSaveRequestDto;
import com.sparta.schedule.dto.ScheduleSaveResponseDto;
import com.sparta.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.sparta.schedule.repository.ScheduleRepository;

// 서비스
// @RequiredArgsConstructor = final 이나 notnull 이 붙은 필드의 생성자를 자동으로 생성해주는 어노테이션
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    //일정등록
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto scheduleSaveRequestDto) {

        // 입력된 RequestDto 에서 생성자 필수값 가져와서 입력.
        Schedule schedule = new Schedule(scheduleSaveRequestDto.getUserName(), scheduleSaveRequestDto.getTitle(),scheduleSaveRequestDto.getUserName());
        // Schedule 객체의 정보를 Repository 에 담고 담은 객체는 saveSchedule
        Schedule saveSchedule = scheduleRepository.save(schedule);

        // repository 까지 연결된 객체의 값을 Dto 에 담아서 반환
        return new ScheduleSaveResponseDto(saveSchedule.getUserName(),saveSchedule.getTitle(),saveSchedule.getContents());
    }
}
