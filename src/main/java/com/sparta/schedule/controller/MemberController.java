package com.sparta.schedule.controller;


import com.sparta.schedule.dto.member.*;
import com.sparta.schedule.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //유저를 저장, 단건 조회, 전체 조회, 삭제할 수 있습니다.
    //유저의 정보는 유저명, 이메일,작성일, 수정일

    //유저를 저장
    @PostMapping("/user")
    public ResponseEntity<MemberSaveResponseDto> saveUser(
            @RequestBody MemberSaveRquestDto memberSaveRquestDto){

        return ResponseEntity.ok((memberService.saveUser(memberSaveRquestDto)));
    }

    //유저 전체 조회
    @GetMapping("/user")
    public ResponseEntity<List<MemberSimpleResponseDto>> getUsers(){
        return ResponseEntity.ok(memberService.getUsers());
    }

    //유저 단건 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<MemberDetailResponseDto> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(memberService.getUser(userId));
    }

    //유저 수정
    @PutMapping("/user/{userId}")
    public ResponseEntity<MemberUpdateResponseDto> updateUser(
            @PathVariable Long userId,
            @RequestBody MemberUpdateRequestDto memberUpdateRequestDto){
        return ResponseEntity.ok(memberService.updateUser(userId,memberUpdateRequestDto));
    }

    //유저 삭제
    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Long userId){
        memberService.deleteUser(userId);
    }
}
