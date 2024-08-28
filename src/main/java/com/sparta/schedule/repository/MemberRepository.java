package com.sparta.schedule.repository;

import com.sparta.schedule.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
