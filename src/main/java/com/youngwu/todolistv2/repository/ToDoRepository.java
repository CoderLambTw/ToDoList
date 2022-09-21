package com.youngwu.todolistv2.repository;

import com.youngwu.todolistv2.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    ToDo findByToDoId(long id);

    List<ToDo> findByUserId(String userId);
}
