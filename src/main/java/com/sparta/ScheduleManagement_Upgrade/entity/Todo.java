package com.sparta.ScheduleManagement_Upgrade.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name")
    private String userName;
    private String email;
    @Column(name="write_date")
    private String writeDate;
    @Column(name="update_date")
    private String updateDate;

    public Todo(){

    }
    public Todo(String userName,String email,String writeDate,String updateDate){
        this.userName=userName;
        this.email=email;
        this.writeDate=writeDate;
        this.updateDate=updateDate;
    }
}
