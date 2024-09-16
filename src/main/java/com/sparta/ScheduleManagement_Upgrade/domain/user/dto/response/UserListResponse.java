package com.sparta.ScheduleManagement_Upgrade.domain.user.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class UserListResponse {
    private String message;
    private Integer statusCode;
    private Integer count;
    private List<UserDto> userDtoList;

}
