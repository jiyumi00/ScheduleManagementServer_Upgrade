package com.sparta.ScheduleManagement_Upgrade.domain.todo.controller;


import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.request.CreateTodoRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.request.UpdateTodoRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.response.CreateTodoResponse;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.response.DeleteTodoResponse;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.response.TodoResponse;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.response.UpdateTodoResponse;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    //일정 저장
    @PostMapping()
   public CreateTodoResponse createTodo(@RequestBody CreateTodoRequest request){
       return todoService.createTodo(request);
   }
   //일정 단건 조회
    @GetMapping("/{id}")
    public TodoResponse getTodo(@PathVariable("id") Long id){
        return todoService.getTodo(id);
    }

    //일정 수정
    @PutMapping("/{id}")
    public UpdateTodoResponse updateTodo(@PathVariable("id") Long id,@RequestBody UpdateTodoRequest request){
        return todoService.updateTodo(id,request);
    }

    //일정 삭제
    @DeleteMapping("/{id}")
    public DeleteTodoResponse deleteTodo(@PathVariable("id") Long id){
        return todoService.deleteTodo(id);
    }

}
