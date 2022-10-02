package com.youngwu.todolistv2.dto;

import com.youngwu.todolistv2.constant.OrderByColumn;
import com.youngwu.todolistv2.constant.Sort;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ToDoQueryParams {

    @ApiModelProperty(value = "事項分類")
    private String category;

    @ApiModelProperty(value = "事項內容（模糊查詢）")
    private String description;

    @ApiModelProperty(value = "欲排序欄位")
    @Enumerated(EnumType.STRING)
    private OrderByColumn orderBy;

    @ApiModelProperty(value = "資料排序方式")
    @Enumerated(EnumType.STRING)
    private Sort sort;

    private Integer page;

    private Integer pageSize;
}
