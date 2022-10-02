package com.youngwu.todolistv2.controller;

import com.youngwu.todolistv2.constant.OrderByColumn;
import com.youngwu.todolistv2.constant.Sort;
import com.youngwu.todolistv2.dto.*;
import com.youngwu.todolistv2.model.BaseResponse;
import com.youngwu.todolistv2.model.ToDo;
import com.youngwu.todolistv2.service.ToDoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@CrossOrigin
@Validated
@Api(value = "待辦事項", tags = {"待辦事項相關功能"})
@RequestMapping(value = "/api/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @ApiOperation("新增事項")
    @PostMapping("/createToDo")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<CreateToDoResponse> createToDo(@RequestBody @Valid CreateToDoRequest request) {
        CreateToDoResponse createToDoResponse = toDoService.createToDo(request);
        return new BaseResponse<>(createToDoResponse);
    }

    @ApiOperation("查詢所有事項")
    @GetMapping("/toDoList")
    public BaseResponse<List<ToDo>> getToDoList(
            // 查詢條件 Filtering
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String description,

            // 排序 Sorting
            @RequestParam(defaultValue = "createDate") OrderByColumn orderBy,
            @RequestParam(defaultValue = "desc") Sort sort,

            //分頁
            @RequestParam(defaultValue = "0") @Min(0) @Max(50) Integer page,
            @RequestParam(defaultValue = "1") @Min(1) @Max(40) Integer pageSize
    ) {
        ToDoQueryParams toDoQueryParams = new ToDoQueryParams();
        toDoQueryParams.setCategory(category);
        toDoQueryParams.setDescription(description);
        toDoQueryParams.setOrderBy(orderBy);
        toDoQueryParams.setSort(sort);
        toDoQueryParams.setPage(page);
        toDoQueryParams.setPageSize(pageSize);
        return new BaseResponse<>(toDoService.getToDoList(toDoQueryParams));
    }

    @ApiOperation("修改事項")
    @PostMapping("/updateToDo")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<UpdateToDoResponse> updateToDo(@RequestBody @Valid UpdateToDoRequest request) {
        UpdateToDoResponse updateToDoResponse = toDoService.updateToDo(request);
        return new BaseResponse<>(updateToDoResponse);
    }

    @ApiOperation("刪除事項")
    @DeleteMapping("/updateToDo/{toDoId}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<DeleteToDoResponse> deleteToDo(@PathVariable long toDoId) {
        DeleteToDoResponse deleteToDoResponse = toDoService.deleteToDo(toDoId);
        return new BaseResponse<>(deleteToDoResponse);
    }
}
