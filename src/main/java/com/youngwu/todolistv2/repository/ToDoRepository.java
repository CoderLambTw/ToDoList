package com.youngwu.todolistv2.repository;

import com.youngwu.todolistv2.model.ToDo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    List<ToDo> findByCategoryAndDescriptionContaining(String category, String description, Pageable pageable);

    List<ToDo> findByCategory(String category);

    List<ToDo> findByDescriptionContaining(String description);
}
