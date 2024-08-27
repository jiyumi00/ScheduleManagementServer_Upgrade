package com.sparta.ScheduleManagement_Upgrade.service;


import com.sparta.ScheduleManagement_Upgrade.domain.Member;
import com.sparta.ScheduleManagement_Upgrade.dto.member.CreateMemberRequest;
import com.sparta.ScheduleManagement_Upgrade.dto.member.CreateMemberResponse;
import com.sparta.ScheduleManagement_Upgrade.dto.member.MemberDto;
import com.sparta.ScheduleManagement_Upgrade.dto.member.MemberListResponse;
import com.sparta.ScheduleManagement_Upgrade.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    public CreateMemberResponse createMember(CreateMemberRequest data){
         //회원 객체 생성
        Member newMember=Member.createNewMember(
                data.getUserName(),
                data.getEmail(),
                data.getWriteDate(),
                data.getUpdateDate()
        );

        //저장
        Member savedMember=memberRepository.save(newMember);

        return new CreateMemberResponse(
                "회원 저장 성공",
                201,
                savedMember.getId()
        );
    }
    public MemberListResponse getMemberList(){
        List<Member> foundMemberList=memberRepository.findAll();

        //객체 -> DTO
        List<MemberDto> memberDtoList=foundMemberList.stream()
                .map(member -> new MemberDto(
                        member.getId(),
                        member.getUserName(),
                        member.getEmail(),
                        member.getWriteDate(),
                        member.getUpdateDate()
                )).toList();

        return new MemberListResponse(
                "회원 전체 조회 성공",
                200,
                memberDtoList.size(),
                memberDtoList
        );
    }

}
