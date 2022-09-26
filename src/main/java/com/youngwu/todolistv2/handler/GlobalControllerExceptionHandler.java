package com.youngwu.todolistv2.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngwu.todolistv2.constant.ErrorPageType;
import com.youngwu.todolistv2.model.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalControllerExceptionHandler {


        @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
        private void controllerError405Handler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception
        {
            BaseResponse<Object> baseResponse = new BaseResponse<>(null);
            baseResponse.setCode(ErrorPageType.ERROR_0405.getReturnCode());
            baseResponse.setMessage(e.getMessage());
            response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response.getOutputStream().print(new ObjectMapper().writeValueAsString(baseResponse));
            response.flushBuffer();
        }

        @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
        private void controllerError415Handler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception
        {
            BaseResponse<Object> baseResponse = new BaseResponse<>(null);
            baseResponse.setCode(ErrorPageType.ERROR_0415.getReturnCode());
            baseResponse.setMessage(e.getMessage());
            response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response.getOutputStream().print(new ObjectMapper().writeValueAsString(baseResponse));
            response.flushBuffer();
        }

//        @ExceptionHandler(value = SessionTimeoutException.class)
//        private void controllerError0004Handler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception
//        {
//            BaseResponse<Object> baseResponse = new BaseResponse<>(null);
//            baseResponse.setCode(ErrorMessage.ERROR_MESSAGE_0004.getCode());
//            baseResponse.setMessage(ErrorMessage.ERROR_MESSAGE_0004.getMessage());
//            response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//            response.getOutputStream().print(new ObjectMapper().writeValueAsString(baseResponse));
//            response.flushBuffer();
//        }

        @ExceptionHandler(value = Exception.class)
        private void controllerError500Handler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception
        {
            BaseResponse<Object> baseResponse = new BaseResponse<>(null);
            baseResponse.setCode(ErrorPageType.ERROR_0500.getReturnCode());
            baseResponse.setMessage(StringUtils.isBlank(e.getMessage()) ? e.toString() : e.getMessage());
            response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response.getOutputStream().print(new ObjectMapper().writeValueAsString(baseResponse));
            response.flushBuffer();
        }
    }
