package com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateTodoRequest {
    private String title;
    private String contents;
}
