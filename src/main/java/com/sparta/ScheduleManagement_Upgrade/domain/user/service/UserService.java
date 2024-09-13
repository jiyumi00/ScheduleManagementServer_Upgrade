package com.sparta.ScheduleManagement_Upgrade.domain.user.service;
import com.sparta.ScheduleManagement_Upgrade.domain.user.dto.request.UpdateUserRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.user.dto.response.*;
import com.sparta.ScheduleManagement_Upgrade.domain.user.entity.User;
import com.sparta.ScheduleManagement_Upgrade.domain.user.repository.UserRepository;
import com.sparta.ScheduleManagement_Upgrade.domain.user.dto.request.CreateUserRequest;
import com.sparta.ScheduleManagement_Upgrade.user.dto.response.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public CreateUserResponse createUser(CreateUserRequest data){
         //회원 객체 생성
        User newUser= User.createNewUser(
                data.getUserName(),
                data.getEmail(),
                data.getWriteDate()
        );
        //저장
        User savedUser=userRepository.save(newUser);

        return new CreateUserResponse(
                "회원 저장 성공",
                201,
                savedUser.getId()
        );
    }
    public UserListResponse getUserList(){
        //전체 조회
        List<User> foundUserList=userRepository.findAll();

        //객체 -> DTO
        List<UserDto> userDtoList=foundUserList.stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getUserName(),
                        user.getEmail(),
                        user.getWriteDate(),
                        user.getUpdateDate()
                )).toList();

        return new UserListResponse(
                "회원 전체 조회 성공",
                200,
                userDtoList.size(),
                userDtoList
        );
    }
    public UserResponse getUserById(Long id){
        //단건 조회
        User foundUser=userRepository.findById(id);
        UserDto userDto=new UserDto(
                foundUser.getId(),
                foundUser.getUserName(),
                foundUser.getEmail(),
                foundUser.getWriteDate(),
                foundUser.getUpdateDate()
        );
        return new UserResponse(
                "회원 단건 조회 성공",
                200,
                userDto
        );
    }
    @Transactional
    public UpdateUserResponse updateUser(Long id, UpdateUserRequest data){
        //회원 조회
        User user=userRepository.findOne(id);

        log.info("user.getUserName={}",user.getUserName());
        if(data.getUserName()!=null){
            user.setUserName(data.getUserName());
        }
        if(data.getEmail()!=null){
            user.setEmail(data.getEmail());
        }
        user.setUpdateDate(data.getUpdateDate());

        User updatedUser=userRepository.findOne(id);
        log.info("updatedUser.getUserName={}",updatedUser.getUserName());
        return new UpdateUserResponse(
                "회원 수정 성공",
                200,
                updatedUser.getId()
        );
    }
    @Transactional
    public DeleteUserResponse deleteUser(Long id){
        //회원 조회
        User user=userRepository.findOne(id);
        if(user!=null){
            userRepository.deleteById(user);
        }
        return new DeleteUserResponse(
                "회원 삭제 성공",
                200,
                id
        );
    }
}
