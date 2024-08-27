package com.sparta.ScheduleManagement_Upgrade.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name", nullable = false)
    private String userName;

    private String email;

    @Column(name="write_date")
    private String writeDate;

    @Column(name="update_date")
    private String updateDate;

//    public Member(){
//
//    }

    protected Member(){

    }
    public static Member createNewMember(String userName,String email,String writeDate, String updateDate){
        Member newMember=new Member();
        newMember.userName=userName;
        newMember.email=email;
        newMember.writeDate=writeDate;
        newMember.updateDate=updateDate;

        return newMember;
    }

}
