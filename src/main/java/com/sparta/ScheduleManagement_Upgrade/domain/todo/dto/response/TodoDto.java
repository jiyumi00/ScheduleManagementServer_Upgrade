package com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoDto {
    private Long id;
    private String email;
    private String title;
    private String todo;
}
