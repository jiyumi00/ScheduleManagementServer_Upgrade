package com.sparta.ScheduleManagement_Upgrade.domain.comment.entity;

import com.sparta.ScheduleManagement_Upgrade.config.common.Timestamped;
import com.sparta.ScheduleManagement_Upgrade.domain.comment.dto.request.UpdateCommentRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.entity.Todo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment extends Timestamped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String contents;

    private String userName;
    @ManyToOne
    @JoinColumn(name="todo_id")
    private Todo todo;

    protected Comment(){

    }
    public static Comment createNewComment(String contents,String userName,Todo todo){
        Comment newComment=new Comment();
        newComment.contents=contents;
        newComment.userName=userName;
        newComment.todo=todo;
        return newComment;
    }

    public void updateComment(UpdateCommentRequest request) {
        if(request.getUserName()!=null){
            this.userName= request.getUserName();
        }
        if(request.getContents()!=null){
            this.contents= request.getContents();
        }
    }
}
