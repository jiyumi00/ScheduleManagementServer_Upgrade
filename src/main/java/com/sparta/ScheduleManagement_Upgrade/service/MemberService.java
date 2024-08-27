package com.sparta.ScheduleManagement_Upgrade.service;


import com.sparta.ScheduleManagement_Upgrade.domain.Member;
import com.sparta.ScheduleManagement_Upgrade.dto.member.*;
import com.sparta.ScheduleManagement_Upgrade.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    public CreateMemberResponse createMember(CreateMemberRequest data){
         //회원 객체 생성
        Member newMember=Member.createNewMember(
                data.getUserName(),
                data.getEmail(),
                data.getWriteDate()
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
        //전체 조회
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

    public MemberResponse getMemberById(Long id){
        //단건 조회
        Member foundMember=memberRepository.findById(id);

        MemberDto memberDto=new MemberDto(
                foundMember.getId(),
                foundMember.getUserName(),
                foundMember.getEmail(),
                foundMember.getWriteDate(),
                foundMember.getUpdateDate()
        );

        return new MemberResponse(
                "회원 단건 조회 성공",
                200,
                memberDto
        );
    }

    @Transactional
    public UpdateMemberResponse updateMember(Long id,UpdateMemberRequest data){
        //회원 조회
        Member member=memberRepository.findOne(id);

        log.info("member.getUserName={}",member.getUserName());
        if(data.getUserName()!=null){
            member.setUserName(data.getUserName());
        }
        if(data.getEmail()!=null){
            member.setEmail(data.getEmail());
        }
        member.setUpdateDate(data.getUpdateDate());

        Member updatedMember=memberRepository.findOne(id);
        log.info("updatedMember.getUserName={}",updatedMember.getUserName());
        return new UpdateMemberResponse(
                "회원 수정 성공",
                200,
                updatedMember.getId()
        );

    }

    @Transactional
    public DeleteMemberResponse deleteMember(Long id){
        //회원 조회
        Member member=memberRepository.findOne(id);
        if(member!=null){
            memberRepository.deleteById(member);
        }
        return new DeleteMemberResponse(
                "회원 삭제 성공",
                200,
                id
        );
    }

}
