package com.youngwu.todolistv2.service;

import com.youngwu.todolistv2.dto.CreateToDoRequest;
import com.youngwu.todolistv2.dto.CreateToDoResponse;
import com.youngwu.todolistv2.dto.UpdateToDoRequest;
import com.youngwu.todolistv2.dto.UpdateToDoResponse;
import com.youngwu.todolistv2.model.ToDo;
import com.youngwu.todolistv2.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public CreateToDoResponse createToDo(CreateToDoRequest request) {
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

    public ToDo getToDoById(long id) {
        return toDoRepository.findByToDoId(id);
    }

    public List<ToDo> getToDoListByUserId(String userId) {
        return toDoRepository.findByUserId(userId);
    }


    public List<ToDo> getToDoList() {
        return toDoRepository.findAll();
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
}
