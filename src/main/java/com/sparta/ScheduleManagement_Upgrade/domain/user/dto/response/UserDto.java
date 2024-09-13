package com.sparta.ScheduleManagement_Upgrade.domain.user.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private String email;
    private String writeDate;
    private String updateDate;
}
