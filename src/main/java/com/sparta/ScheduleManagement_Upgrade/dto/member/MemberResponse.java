package com.sparta.ScheduleManagement_Upgrade.dto.member;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberResponse {
    private String message;
    private Integer statusCode;
    private MemberDto memberDto;
}
