package com.youngwu.todolistv2.controller;

import com.youngwu.todolistv2.dto.CreateToDoRequest;
import com.youngwu.todolistv2.dto.CreateToDoResponse;
import com.youngwu.todolistv2.dto.UpdateToDoRequest;
import com.youngwu.todolistv2.dto.UpdateToDoResponse;
import com.youngwu.todolistv2.model.ToDo;
import com.youngwu.todolistv2.service.ToDoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@Api(value = "待辦事項", tags = {"待辦事項相關功能"})
@RequestMapping(value = "/api/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @ApiOperation("新增事項")
    @PostMapping("/createToDo")
    public CreateToDoResponse createToDo(@RequestBody @Valid CreateToDoRequest request) {
        return toDoService.createToDo(request);
    }

    @ApiOperation("查詢所有事項")
    @GetMapping("/toDoList")
    public List<ToDo> getToDoList() {
        return toDoService.getToDoList();
    }

    @ApiOperation("修改事項")
    @PostMapping("/updateToDo")
    public UpdateToDoResponse updateToDo(@RequestBody @Valid UpdateToDoRequest request) {
        return toDoService.updateToDo(request);
    }
}
