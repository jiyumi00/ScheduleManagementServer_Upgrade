package com.sparta.ScheduleManagement_Upgrade.domain.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequest {
    private String userName;
    private String email;
    private String writeDate;
}
