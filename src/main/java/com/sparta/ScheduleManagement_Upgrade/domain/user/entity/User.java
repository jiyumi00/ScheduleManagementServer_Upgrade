package com.sparta.ScheduleManagement_Upgrade.domain.user.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String userName;

    @Column(length = 30,nullable = false)
    private String email;

    @Column(nullable = false)
    private String writeDate;

    private String updateDate;

    protected User(){

    }
    public static User createNewUser(String userName, String email, String writeDate){
        User newUser=new User();
        newUser.userName=userName;
        newUser.email=email;
        newUser.writeDate=writeDate;
        return newUser;
    }
}
