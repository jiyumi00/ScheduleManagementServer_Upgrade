package com.sparta.ScheduleManagement_Upgrade.domain.user.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserRequest {
    private String userName;
    private String email;
    private String writeDate;
}
