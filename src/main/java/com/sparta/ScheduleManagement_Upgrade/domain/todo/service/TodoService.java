package com.sparta.ScheduleManagement_Upgrade.domain.todo.service;

import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.request.CreateTodoRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.request.UpdateTodoRequest;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.dto.response.*;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.entity.Todo;
import com.sparta.ScheduleManagement_Upgrade.domain.todo.repository.TodoRepository;
import com.sparta.ScheduleManagement_Upgrade.domain.user.repository.UserRepository;
import com.sun.jdi.request.InvalidRequestStateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public CreateTodoResponse createTodo(CreateTodoRequest request) {
        //일정 객체 생성
        Todo newTodo=Todo.createNewTodo(
                request.getUserName(),
                request.getTitle(),
                request.getContents()
        );

        //저장
        Todo savedTodo=todoRepository.save(newTodo);

        return new CreateTodoResponse(
                "일정 저장 성공",
                201,
                savedTodo.getId()
        );
    }

    public TodoResponse getTodo(Long id) {
        //단건 조회
        Todo foundTodo=todoRepository.findById(id).orElseThrow(()-> new InvalidRequestStateException("Todo not found"));

        TodoDto todoDto=new TodoDto(
                foundTodo.getId(),
                foundTodo.getUserName(),
                foundTodo.getTitle(),
                foundTodo.getContents()
        );
        return new TodoResponse(
                "일정 단건 조회 성공",
                200,
                todoDto
        );
    }

    @Transactional
    public UpdateTodoResponse updateTodo(Long id, UpdateTodoRequest request) {
        //일정 조회
        Todo todo=todoRepository.findById(id).orElseThrow(()->new InvalidRequestStateException("Todo not found"));


        todo.updateTodo(request.getTitle(),request.getContents());

        return new UpdateTodoResponse(
                "일정 수정 성공",
                201,
                todo.getId()
        );
    }

    public DeleteTodoResponse deleteTodo(Long id) {
        //일정 조회
        Todo todo=todoRepository.findById(id).orElseThrow(()->new InvalidRequestStateException("Todo not found"));

        todoRepository.deleteById(id);

        return new DeleteTodoResponse(
                "일정 삭제 성공",
                200,
                id
        );
    }
}
