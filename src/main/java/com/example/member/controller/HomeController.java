package com.example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // Method (기본 페이지 요청)
    @GetMapping("/")
    public String index() {
        return "index"; // index.html 찾아가기
    }
}
