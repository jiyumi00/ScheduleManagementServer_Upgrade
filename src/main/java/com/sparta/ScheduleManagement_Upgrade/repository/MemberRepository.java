package com.sparta.ScheduleManagement_Upgrade.repository;


import com.sparta.ScheduleManagement_Upgrade.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager entityManager;

    //회원저장
    @Transactional
    public Member save(Member member){
        entityManager.persist(member);
        return member;
    }

    //회원 목록 조회
    public List<Member> findAll(){
        String jpql="SELECT m FROM Member m";
        return entityManager
                .createQuery(jpql,Member.class)
                .getResultList();
    }
}
