package com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TodoDto {
    private Long id;
    private String title;
    private String todo;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
