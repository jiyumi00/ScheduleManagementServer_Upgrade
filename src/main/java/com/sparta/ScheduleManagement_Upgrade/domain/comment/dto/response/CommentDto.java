package com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private String userName;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
