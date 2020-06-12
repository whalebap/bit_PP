package com.person.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("")
    public String Home(){
        return "홈 컨트롤러 입니다";
    }
}
