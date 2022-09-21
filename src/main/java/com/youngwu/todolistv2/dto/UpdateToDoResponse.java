package com.youngwu.todolistv2.dto;

import com.sun.istack.NotNull;
import com.youngwu.todolistv2.constant.FinishFlag;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateToDoResponse {
//    @NotNull
//    @ApiModelProperty(value = "待辦事項id", required = true)
//    private long id;
//
//    @NotNull
//    @ApiModelProperty(value = "用戶id", required = true)
//    private String userId;
//
//    @NotNull
//    @ApiModelProperty(value = "ToDo內文", required = true)
//    private String description;
//
//    @NotNull
//    @ApiModelProperty(value = "分類", required = true)
//    private String category;
//
//    @NotNull
//    @ApiModelProperty(value = "完成flag", required = true, example = "N, Y")
//    private FinishFlag isFinish;

    @ApiModelProperty(value = "回傳狀態", required = true)
    String status;
}
