package com.youngwu.todolistv2.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateToDoRequest {

    @NotNull
    @ApiModelProperty(value = "用戶名稱", required = true)
    private String userId;

    @NotNull
    @ApiModelProperty(value = "ToDo內文", required = true)
    private String description;


}
