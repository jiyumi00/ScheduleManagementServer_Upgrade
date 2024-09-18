package com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateTodoRequest {
    private String title;
    private String contents;
}
