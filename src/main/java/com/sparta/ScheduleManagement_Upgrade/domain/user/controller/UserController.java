package com.sparta.ScheduleManagement_Upgrade.domain.user.controller;



import com.sparta.ScheduleManagement_Upgrade.domain.user.dto.request.UpdateUserRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.user.dto.response.*;
import com.sparta.ScheduleManagement_Upgrade.domain.user.dto.request.CreateUserRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    //회원 저장
    @PostMapping()
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }
    //회원 전체 조회
    @GetMapping()
    public UserListResponse getUserList(){
        return userService.getUserList();
    }
    //회원 단건 조회
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id){
        return userService.getUser(id);
    }
    //회원 수정
    @PutMapping("/{id}")
    public UpdateUserResponse updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequest request){
        return userService.updateUser(id,request);
    }
    //회원 삭제
    @DeleteMapping("/{id}")
    public DeleteUserResponse deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
