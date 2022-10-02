package com.youngwu.todolistv2.service;

import com.youngwu.todolistv2.dto.*;
import com.youngwu.todolistv2.model.ToDo;
import com.youngwu.todolistv2.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public CreateToDoResponse createToDo(@NotNull CreateToDoRequest request) {
        ToDo toDo = new ToDo();
        toDo.setUserId(request.getUserId()); // 用戶id
        toDo.setDescription(request.getDescription()); // 內文
        toDo.setCategory(request.getCategory()); // 分類
        toDo.setIsFinish(request.getIsFinish()); // finishFlag
        Date now = new Date();
        toDo.setCreateDate(now); // 創建時間
        toDo.setUpdateDate(now); // 修改時間
        toDoRepository.save(toDo);

        CreateToDoResponse response = new CreateToDoResponse();
        response.setStatus("Success");
        return response;
    }

    public List<ToDo> getToDoList(ToDoQueryParams toDoQueryParams) {
        //查詢條件
        String category = toDoQueryParams.getCategory();
        String description = toDoQueryParams.getDescription();

        //排序條件
        String orderBy = toDoQueryParams.getOrderBy().name();
        String sort = toDoQueryParams.getSort().name();

        //分頁功能
        int page = toDoQueryParams.getPage();
        int pageSize = toDoQueryParams.getPageSize();

        Sort sortBy = Sort.by(orderBy).descending();
        if ("asc".equals(sort)) {
            sortBy = Sort.by(orderBy).descending();
        }

        Pageable pageable = PageRequest.of(page, pageSize, sortBy);
        if (category != null && description != null) {
            return toDoRepository.findByCategoryAndDescriptionContaining(category, description, pageable);
        } else if (category != null) {
            return toDoRepository.findByCategory(category);
        } else if (description != null) {
            return toDoRepository.findByDescriptionContaining(description);
        } else {
            return toDoRepository.findAll();
        }
    }

    public UpdateToDoResponse updateToDo(UpdateToDoRequest request) {

        Optional<ToDo> toDoOptional = toDoRepository.findById(request.getToDoId());
        UpdateToDoResponse response = new UpdateToDoResponse();

        if(!toDoOptional.isEmpty()) {
            ToDo toDo = toDoOptional.get();
            toDo.setUserId(request.getUserId()); // 用戶id
            toDo.setDescription(request.getDescription()); // 內文
            toDo.setCategory(request.getCategory()); // 分類
            toDo.setIsFinish(request.getIsFinish()); // finishFlag

            Date now = new Date();
            toDo.setUpdateDate(now); // 修改時間
            toDoRepository.save(toDo);
            response.setStatus("Update Success");
        } else {
            response.setStatus("Update failed");
        }
        return response;
    }

    public DeleteToDoResponse deleteToDo(long toDoId) {
        DeleteToDoResponse response = new DeleteToDoResponse();
        toDoRepository.deleteById(toDoId);
        response.setDeleteProductId(toDoId);
        return response;
    }
}
