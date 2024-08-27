package com.sparta.ScheduleManagement_Upgrade.dto.member;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String userName;
    private String email;
    private String writeDate;
    private String updateDate;
}
