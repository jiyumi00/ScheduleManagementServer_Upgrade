package com.sparta.ScheduleManagement_Upgrade.domain.user.repository;


import com.sparta.ScheduleManagement_Upgrade.domain.user.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager entityManager;
    //회원저장
    @Transactional
    public User save(User user){
        entityManager.persist(user);
        return user;
    }
    //회원 목록 조회
    public List<User> findAll(){
        String jpql="SELECT m FROM User m";
        return entityManager
                .createQuery(jpql, User.class)
                .getResultList();
    }
    //회원 단건 조회
    public User findById(Long id){
        String jpql="SELECT m from User m where m.id=:id";
        return entityManager
                .createQuery(jpql, User.class)
                .setParameter("id",id)
                .getSingleResult();
    }
    public User findOne(Long id){
        return entityManager.find(User.class,id);
    }
    public void deleteById(User user){
        entityManager.remove(user);
    }
}
