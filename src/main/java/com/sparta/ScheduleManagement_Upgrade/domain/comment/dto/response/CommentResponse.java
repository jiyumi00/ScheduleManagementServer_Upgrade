package com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class CommentResponse {
    private String message;
    private Integer statusCode;
    private CommentDto commentDto;
}
