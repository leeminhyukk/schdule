package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class MemberSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "memeber_id")
    Member member;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    Schedule schedule;

}
