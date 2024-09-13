package com.sparta.ScheduleManagement_Upgrade.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserRequest {
    private String userName;
    private String email;
    private String updateDate;
}
