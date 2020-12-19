package com.ppdai.sentinel.quick_start.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hxt
 * @version 1.0
 * @date 2020/12/14
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        //使用限流规则
        try (Entry entry = SphU.entry("HelloWorld")) {
            return "Hello Sentinel!";
        } catch (BlockException e) {
            e.printStackTrace();
            return "系统繁忙，请稍候";
        }
    }

    /**
     * 定义限流规则
     *
     * @PostConstruct:当前类的构造函数执行之后执行
     */
//    @PostConstruct
//    public void initFLowRules() {
//        //1.创建限流规则
//        List<FlowRule> rules = new ArrayList<>();
//        FlowRule rule = new FlowRule();
//        //定义资源,表示Sentinel会对哪个资源生效
//        rule.setResource("HelloWorld");
//        //定义限流规则类型,QPS限流类型
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        //定义QPS每秒能通过的请求个数
//        rule.setCount(2);
//        rules.add(rule);
//        //2.加载限流规则
//        FlowRuleManager.loadRules(rules);
//    }
}
