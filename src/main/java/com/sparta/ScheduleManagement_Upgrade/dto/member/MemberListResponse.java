package com.sparta.ScheduleManagement_Upgrade.dto.member;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MemberListResponse {
    private String message;
    private Integer statusCode;
    private Integer count;
    private List<MemberDto> memberDtoList;

}
