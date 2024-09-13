package com.sparta.ScheduleManagement_Upgrade.domain.user.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteUserResponse {
    private String message;
    private Integer statusCode;
    private Long userId;
}
