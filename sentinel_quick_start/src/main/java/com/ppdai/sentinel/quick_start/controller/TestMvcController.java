package com.ppdai.sentinel.quick_start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxt
 * @version 1.0
 * @date 2020/12/19
 */
@RestController
@RequestMapping("/api")
public class TestMvcController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Sentinel!";
    }
}
