package com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCommentResponse {
    private String message;
    private Integer statusCode;
    private Long commentId;
}
