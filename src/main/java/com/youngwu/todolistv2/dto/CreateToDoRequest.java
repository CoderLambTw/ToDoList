package com.youngwu.todolistv2.dto;

import com.sun.istack.NotNull;
import com.youngwu.todolistv2.constant.FinishFlag;
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

    @NotNull
    @ApiModelProperty(value = "分類", required = true)
    private String category;

    @NotNull
    @ApiModelProperty(value = "完成flag", required = true, example = "N, Y")
    private FinishFlag isFinish;
}
