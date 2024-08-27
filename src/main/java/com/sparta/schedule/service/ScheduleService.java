package com.sparta.schedule.service;

import com.sparta.schedule.dto.*;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


// 서비스
// @RequiredArgsConstructor = final 이나 notnull 이 붙은 필드의 생성자를 자동으로 생성해주는 어노테이션
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    //일정등록
    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto scheduleSaveRequestDto) {

        // 입력된 RequestDto 에서 생성자 필수값 가져와서 입력.
        Schedule schedule = new Schedule(scheduleSaveRequestDto.getUserName(), scheduleSaveRequestDto.getTitle(), scheduleSaveRequestDto.getUserName());
        // Schedule 객체의 정보를 Repository 에 담고 담은 객체는 saveSchedule
        Schedule saveSchedule = scheduleRepository.save(schedule);

        // repository 까지 연결된 객체의 값을 Dto 에 담아서 반환
        return new ScheduleSaveResponseDto(
                saveSchedule.getUserName(),
                saveSchedule.getTitle(),
                saveSchedule.getContents(),
                saveSchedule.getCreateAt());
    }

    //단일 조회
    public ScheduleDetailResponseDto getSchedule(Long scheduleId) {
        // 레퍼지토리 객체를 통해 등록된 Id 조회 및 없으면 예외처리
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("등록된 스케쥴이 없습니다."));

        return new ScheduleDetailResponseDto(
                schedule.getUserName(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreateAt());
    }

    //수정
    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long scheduleId, ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
        // 단일 조회에서 만든거 복사해서 썼습니다. ID 로 조회 없으면 예외처리.
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("등록된 스케쥴이 없습니다."));

        // entity 에 update 메서드를 만들어서 처리
        schedule.update(scheduleUpdateRequestDto.getTitle(), scheduleUpdateRequestDto.getContents());
        return new ScheduleUpdateResponseDto(
                schedule.getUserName(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreateAt(),
                schedule.getModifiedAt());

    }
}
