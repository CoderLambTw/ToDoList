package com.youngwu.todolistv2.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "回傳代碼. 0000: 成功, 非0000: 失敗")
    private String code = "0000"; // default 0000

    @ApiModelProperty(notes = "回傳訊息. code爲0000時回傳success, 反之回傳錯誤訊息")
    private String message = "Success"; // default Success

    @ApiModelProperty(notes = "回傳資料")
    private T data;

    public BaseResponse(T data) {
        this.data = data;
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
