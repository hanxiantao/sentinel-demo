package com.ppdai.sentinel_rule.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author hxt
 * @version 1.0
 * @date 2020/12/20
 */
@RestController
public class DegradeController {
    @SentinelResource(value = "Sentinel_Rule", blockHandler = "exceptionHandler")
    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        Random random = new Random();
        Thread.sleep(random.nextInt(1000));
        return "Hello Sentinel!";
    }

    public String exceptionHandler(BlockException ex) {
        ex.printStackTrace();
        return "系统繁忙，请稍候";
    }
}
