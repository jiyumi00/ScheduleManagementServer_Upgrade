package com.sparta.ScheduleManagement_Upgrade.domain.comment.controller;


import com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.request.CreateCommentRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.request.UpdateCommentRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.response.*;
import com.sparta.ScheduleManagement_Upgrade.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    //댓글 등록
    @PostMapping("/comments/{todoId}")
    public CreateCommentResponse createComment(@PathVariable("todoId") Long todoId, @RequestBody CreateCommentRequest request){
        return commentService.createComment(todoId,request);
    }

    //댓글 단건 조회
    @GetMapping("/comments/{id}")
    public CommentResponse getComment(@PathVariable("id") Long id){
        return commentService.getComment(id);
    }

    //댓글 전체 조회
    @GetMapping("/todos/{todoId}/comments")
    public CommentListResponse getComments(@PathVariable("todoId") Long todoId){
        return commentService.getComments(todoId);
    }

    //댓글 수정
    @PutMapping("/comments/{id}")
    public UpdateCommentResponse updateComment(@PathVariable("id") Long id , @RequestBody UpdateCommentRequest request){
        return commentService.updateComment(id,request);
    }

    //댓글 삭제
    @DeleteMapping("/comments/{id}")
    public DeleteCommentResponse deleteComment(@PathVariable("id") Long id){
        return commentService.deleteComment(id);
    }
}
