package com.sparta.ScheduleManagement_Upgrade.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private String message;
    private Integer statusCode;
    private UserDto userDto;
}
