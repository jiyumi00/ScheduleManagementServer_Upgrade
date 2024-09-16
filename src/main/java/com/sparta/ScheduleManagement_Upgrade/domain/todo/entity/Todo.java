package com.sparta.ScheduleManagement_Upgrade.domain.todo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 15)
    private String userName;

    @Column(length = 30)
    private String title;

    @Column(length=50)
    private String contents;


    protected Todo(){

    }
    public static Todo createNewTodo(String userName,String title,String contents){
        Todo newTodo=new Todo();
        newTodo.userName=userName;
        newTodo.title=title;
        newTodo.contents=contents;
        return newTodo;
    }

    public void updateTodo(String title,String contents){
        this.title=title;
        this.contents=contents;
    }
}
