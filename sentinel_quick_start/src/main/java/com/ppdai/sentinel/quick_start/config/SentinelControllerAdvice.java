package com.ppdai.sentinel.quick_start.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author hxt
 * @version 1.0
 * @date 2020/12/19
 */
@Slf4j
@ControllerAdvice
@Order(0)
public class SentinelControllerAdvice {
    @ExceptionHandler(BlockException.class)
    @ResponseBody
    public ResponseEntity<?> sentinelBlockHandler(HttpServletRequest request, BlockException e) {
        log.warn("Blocked by Sentinel: {}", e.getRule());
        HashMap<String, Object> map = new HashMap<>();
        map.put("path", request.getServletPath());
        map.put("msg", "limited by sentinel");
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(map);
    }

}
