package com.jacklin.myshop.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 控制台页面
 */
@Api("主页接口")
@Controller
public class ConsoleController {

    @GetMapping("/")
    public String loginUi() {
        return "admin/index";
    }

    @GetMapping("/home/console")
    public String console() {

        return "admin/home/console";
    }
}
