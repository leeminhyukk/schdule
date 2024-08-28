package com.sparta.schedule.service;


import com.sparta.schedule.dto.member.*;
import com.sparta.schedule.entity.Member;
import com.sparta.schedule.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //유저 등록
    @Transactional
    public MemberSaveResponseDto saveUser(MemberSaveRquestDto memberSaveRquestDto) {
        Member member = new Member(memberSaveRquestDto.getName(), memberSaveRquestDto.getEmail());
        Member savedMember = memberRepository.save(member);

        return new MemberSaveResponseDto(savedMember.getName(), savedMember.getEmail(), savedMember.getCreatedAt(), savedMember.getModifiedAt());
    }

    //유저 전체 조회
    public List<MemberSimpleResponseDto> getUsers() {
        List<Member> members = memberRepository.findAll();

        List<MemberSimpleResponseDto> dtoList = new ArrayList<>();
        for(Member member : members){
            MemberSimpleResponseDto dto = new MemberSimpleResponseDto(member.getName(), member.getEmail(), member.getCreatedAt(), member.getModifiedAt());
            dtoList.add(dto);
        }
        return dtoList;
    }

    //유저 단건 조회
    public MemberDetailResponseDto getUser(Long userId) {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new NullPointerException("등록된 유저가 없습니다."));
        return new MemberDetailResponseDto(member.getName(), member.getEmail(), member.getCreatedAt(), member.getModifiedAt());
    }

    //유저 정보 수정
    @Transactional
    public MemberUpdateResponseDto updateUser(Long userId,MemberUpdateRequestDto memberUpdateRequestDto) {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new NullPointerException("등록된 유저가 없습니다."));
        member.update(memberUpdateRequestDto.getName(),memberUpdateRequestDto.getEmail());
        return new MemberUpdateResponseDto(member.getName(),member.getEmail(),member.getModifiedAt());
    }

    //유저 삭제
    @Transactional
    public void deleteUser(Long userId) {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new NullPointerException("등록된 유저가 없습니다."));
        memberRepository.delete(member);
    }




}
