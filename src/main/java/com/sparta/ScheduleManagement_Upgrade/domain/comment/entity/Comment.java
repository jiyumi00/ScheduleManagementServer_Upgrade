package com.sparta.ScheduleManagement_Upgrade.domain.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String contents;

    @Column(nullable = false,length = 15)
    private String userName;
    private Long userId;
    private Long todoId;
}
