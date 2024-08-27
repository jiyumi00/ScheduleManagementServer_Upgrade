package com.sparta.ScheduleManagement_Upgrade.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMemberResponse {
    private String message;
    private Integer statusCode;
    private Long memberId;
}
