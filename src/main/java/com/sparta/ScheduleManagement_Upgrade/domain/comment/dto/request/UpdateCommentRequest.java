package com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateCommentRequest {
    private String userName;
    private String contents;
}
