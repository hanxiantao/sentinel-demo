package com.ppdai.sentinel.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxt
 * @version 1.0
 * @date 2020/12/19
 */
@RestController
public class TestController {
    //定义资源 value:设置资源的名称 blockHandler:设置限流或降级的处理函数
    @SentinelResource(value = "Sentinel_SpringCloud", blockHandler = "exceptionHandler")
    @GetMapping("/hello")
    public String hello() {
        return "Hello Sentinel!";
    }

    //被限流的处理函数
    public String exceptionHandler(BlockException ex) {
        ex.printStackTrace();
        return "系统繁忙，请稍候";
    }
}
