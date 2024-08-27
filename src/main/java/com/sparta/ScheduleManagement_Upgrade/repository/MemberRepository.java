package com.sparta.ScheduleManagement_Upgrade.repository;


import com.sparta.ScheduleManagement_Upgrade.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager entityManager;

    @Transactional
    public Member save(Member member){
        log.info("DB 저장");
        entityManager.persist(member);
        return member;
    }
}
