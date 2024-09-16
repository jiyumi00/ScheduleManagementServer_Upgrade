package com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateTodoResponse {
    private String message;
    private Integer statusCode;
    private Long todoId;
}
