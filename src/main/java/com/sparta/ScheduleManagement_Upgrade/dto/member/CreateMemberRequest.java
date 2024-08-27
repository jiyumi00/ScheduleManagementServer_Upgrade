package com.sparta.ScheduleManagement_Upgrade.dto.member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateMemberRequest {
    private String userName;
    private String email;
    private String writeDate;
    private String updateDate;

}
