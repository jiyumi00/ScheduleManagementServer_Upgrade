package com.sparta.ScheduleManagement_Upgrade.domain.todo.repository;

import com.sparta.ScheduleManagement_Upgrade.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
