package com.youngwu.todolistv2.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteToDoResponse {

    @NotNull
    @ApiModelProperty(value = "刪除事項id", required = true)
    private long deleteProductId;
}
