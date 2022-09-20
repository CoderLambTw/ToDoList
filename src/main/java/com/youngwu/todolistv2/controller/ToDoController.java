package com.youngwu.todolistv2.controller;

import com.youngwu.todolistv2.dto.CreateToDoRequest;
import com.youngwu.todolistv2.dto.CreateToDoResponse;
import com.youngwu.todolistv2.service.ToDoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @ApiOperation("新增ToDo")
    @PostMapping("/createToDo")
    public CreateToDoResponse createToDo(CreateToDoRequest request) {
        return toDoService.createTodo(request);
    }
}
