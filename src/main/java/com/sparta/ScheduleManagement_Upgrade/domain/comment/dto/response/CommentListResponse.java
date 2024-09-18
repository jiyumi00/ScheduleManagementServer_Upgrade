package com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CommentListResponse {
    private String message;
    private Integer statusCode;
    private Integer commentCount;
    private List<CommentDto> commentDto;
}
