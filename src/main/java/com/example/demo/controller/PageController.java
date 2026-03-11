package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/dept/list")
    public String deptList() {
        return "dept/list";
    }
    @GetMapping("/user/list")
    public String userList() {
        return "user/list";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}