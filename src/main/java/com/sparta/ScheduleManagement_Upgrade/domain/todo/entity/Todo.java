package com.sparta.ScheduleManagement_Upgrade.domain.todo.entity;


import com.sparta.ScheduleManagement_Upgrade.config.common.Timestamped;
import com.sparta.ScheduleManagement_Upgrade.domain.comment.entity.Comment;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.request.UpdateTodoRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Todo extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String title;

    @Column(length=50)
    private String contents;


    //private long userId;
//    @ManyToOne
//    @JoinColumn(name="user_id") //조인해야 하는 컬럼은 user_id
//    private User user;

    protected Todo(){

    }
    public static Todo createNewTodo(String title,String contents){
        Todo newTodo=new Todo();
        newTodo.title=title;
        newTodo.contents=contents;
        return newTodo;
    }

    public void updateTodo(UpdateTodoRequest request){
        if(request.getTitle()!=null){
            this.title=request.getTitle();
        }
        if(request.getContents()!=null){
            this.contents=request.getContents();
        }
    }
}
