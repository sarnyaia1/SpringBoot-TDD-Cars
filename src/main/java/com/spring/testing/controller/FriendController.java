package com.spring.testing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FriendController {

    @GetMapping("/friend")
    public @ResponseBody String greeting() {
        return "Hello, my Friend!!";
    }

}
