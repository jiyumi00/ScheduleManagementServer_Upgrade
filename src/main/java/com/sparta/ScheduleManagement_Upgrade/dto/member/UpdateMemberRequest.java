package com.sparta.ScheduleManagement_Upgrade.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class UpdateMemberRequest {
    private String userName;
    private String email;
    private String updateDate;
}
