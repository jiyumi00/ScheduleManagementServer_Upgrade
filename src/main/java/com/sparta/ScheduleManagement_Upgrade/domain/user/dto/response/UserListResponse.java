package com.sparta.ScheduleManagement_Upgrade.domain.user.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserListResponse {
    private String message;
    private Integer statusCode;
    private Integer count;
    private List<UserDto> userDtoList;

}
