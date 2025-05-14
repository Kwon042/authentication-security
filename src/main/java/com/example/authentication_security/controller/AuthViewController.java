package com.example.authentication_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// 로그인 및 홈 페이지 렌더링용
public class AuthViewController {

    @GetMapping("/")
    public String showMainPage() {
        return "home";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }


}
