package com.sparta.ScheduleManagement_Upgrade.controller;


import com.sparta.ScheduleManagement_Upgrade.dto.member.*;
import com.sparta.ScheduleManagement_Upgrade.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    //회원 수정
    @PutMapping("/{id}")
    public UpdateMemberResponse updateMember(@PathVariable("id") Long id, @RequestBody UpdateMemberRequest request){
        return memberService.updateMember(id,request);
    }

    //회원 삭제
    @DeleteMapping("/{id}")
    public DeleteMemberResponse deleteMember(@PathVariable("id") Long id){
        return memberService.deleteMember(id);
    }


}
