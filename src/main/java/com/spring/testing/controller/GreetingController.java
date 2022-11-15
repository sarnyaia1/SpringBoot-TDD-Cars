package com.spring.testing.controller;

import com.spring.testing.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService service;

    @RequestMapping("/greeting")
    public @ResponseBody String greeting() {
        return service.greet();
    }

}