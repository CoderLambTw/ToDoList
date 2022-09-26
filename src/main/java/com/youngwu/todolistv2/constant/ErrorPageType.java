package com.youngwu.todolistv2.constant;

import lombok.Getter;

public enum ErrorPageType {
    //ERROR("/error"), // Global Error 錯誤
    //SYSTEM_ERROR("/system_error"), // Global Error 錯誤
    ERROR_0400("/400", "0400"), // 400錯誤
    ERROR_0401("/401", "0401"), // 401錯誤
    ERROR_0403("/403", "0403"), // 403錯誤
    ERROR_0404("/404", "0404"), // 404錯誤
    ERROR_0405("/405", "0405"), // 405錯誤
    ERROR_0415("/415", "0415"), // 415錯誤
    ERROR_0500("/500", "0500"), // 500錯誤
    ;

    @Getter
    private String key;

    @Getter
    private final String code;

    @Getter
    private final String returnCode;

    ErrorPageType(String code, String returnCode)
    {
        this.code = code;
        this.returnCode = returnCode;
    }

    public static ErrorPageType toTypeByCode(String code)
    {
        for (ErrorPageType val : ErrorPageType.class.getEnumConstants())
        {
            if (val.getCode().equals(code))
                return val;
        }
        return null;
    }

    public static ErrorPageType toTypeByReturnCode(String returnCode)
    {
        for (ErrorPageType val : ErrorPageType.class.getEnumConstants())
        {
            if (val.getReturnCode().equals(returnCode))
                return val;
        }
        return null;
    }
}
