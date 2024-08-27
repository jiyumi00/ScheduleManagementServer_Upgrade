package com.sparta.ScheduleManagement_Upgrade.service;


import com.sparta.ScheduleManagement_Upgrade.domain.Member;
import com.sparta.ScheduleManagement_Upgrade.dto.member.CreateMemberRequest;
import com.sparta.ScheduleManagement_Upgrade.dto.member.CreateMemberResponse;
import com.sparta.ScheduleManagement_Upgrade.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                "회원 저장 완료",
                201,
                savedMember.getId()
        );

    }
}
