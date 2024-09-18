package com.sparta.ScheduleManagement_Upgrade.domain.comment.service;

import com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.request.CreateCommentRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.request.UpdateCommentRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.response.*;
import com.sparta.ScheduleManagement_Upgrade.domain.comment.entity.Comment;
import com.sparta.ScheduleManagement_Upgrade.domain.comment.repository.CommentRepository;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.entity.Todo;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CreateCommentResponse createComment(Long todoId, CreateCommentRequest request) {
        //일정 확인
        Todo todo=todoRepository.findById(todoId).orElseThrow(()->
                new NullPointerException("Todo not found"));

        Comment newComment=Comment.createNewComment(request.getContents(),request.getUserName(),todo);

        //저장
        Comment savedComment=commentRepository.save(newComment);

        return new CreateCommentResponse(
                "댓글 저장 성공",
                201,
                savedComment.getId()
        );
    }

    public CommentResponse getComment(Long id) {
        //댓글 확인
        Comment foundComment=commentRepository.findById(id).orElseThrow(()->
                new NullPointerException("Comment not found"));

        CommentDto commentDto=new CommentDto(
                foundComment.getId(),
                foundComment.getUserName(),
                foundComment.getContents(),
                foundComment.getCreateAt(),
                foundComment.getUpdateAt()
        );

       return new CommentResponse(
               "댓글 단건 조회 성공",
               200,
               commentDto
       );
    }

    public CommentListResponse getComments(Long todoId) {
        List<Comment> commentList=commentRepository.findByTodoId(todoId);
        List<CommentDto> commentDtoList=new ArrayList<>();

        for(Comment comment:commentList){
            CommentDto commentDto=new CommentDto(
                    comment.getId(),
                    comment.getUserName(),
                    comment.getContents(),
                    comment.getCreateAt(),
                    comment.getUpdateAt()
            );
            commentDtoList.add(commentDto);
        }
        return new CommentListResponse(
                "댓글 전체 조회 성공",
                200,
                commentDtoList.size(),
                commentDtoList
        );
    }

    @Transactional
    public UpdateCommentResponse updateComment(Long id, UpdateCommentRequest request) {
        Comment comment=commentRepository.findById(id).orElseThrow(()->
                new NullPointerException("Comment not found"));

        comment.updateComment(request);

        return new UpdateCommentResponse(
                "댓글 수정 성공",
                201,
                comment.getId()
        );
    }

    @Transactional
    public DeleteCommentResponse deleteComment(Long id) {
        Comment comment=commentRepository.findById(id).orElseThrow(()->
                new NullPointerException("Comment not found"));

        commentRepository.deleteById(id);

        return new DeleteCommentResponse(
                "댓글 삭제 성공",
                200,
                comment.getId()
        );
    }
}
