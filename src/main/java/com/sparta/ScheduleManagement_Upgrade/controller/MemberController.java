package com.sparta.ScheduleManagement_Upgrade.controller;


import com.sparta.ScheduleManagement_Upgrade.dto.member.CreateMemberRequest;
import com.sparta.ScheduleManagement_Upgrade.dto.member.CreateMemberResponse;
import com.sparta.ScheduleManagement_Upgrade.dto.member.MemberListResponse;
import com.sparta.ScheduleManagement_Upgrade.dto.member.MemberResponse;
import com.sparta.ScheduleManagement_Upgrade.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    //회원 저장
    @PostMapping()
    public CreateMemberResponse createMember(@RequestBody CreateMemberRequest request){
        return memberService.createMember(request);
    }

    //회원 전체 조회
    @GetMapping()
    public MemberListResponse getMemberList(){
        return memberService.getMemberList();
    }

    //회원 단건 조회
    @GetMapping("/{id}")
    public MemberResponse getMemberById(@PathVariable("id") Long id){
        return memberService.getMemberById(id);
    }





}
