package com.jacklin.myshop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("message", e.getMessage());
        return map;
    }
}