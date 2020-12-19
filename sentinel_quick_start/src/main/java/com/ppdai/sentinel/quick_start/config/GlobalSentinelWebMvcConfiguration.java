package com.ppdai.sentinel.quick_start.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.SentinelWebInterceptor;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.config.SentinelWebMvcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hxt
 * @version 1.0
 * @date 2020/12/19
 */
@Configuration
public class GlobalSentinelWebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        SentinelWebMvcConfig sentinelWebMvcConfig = new SentinelWebMvcConfig();
        //指定请求方法:GET、POST等等
        sentinelWebMvcConfig.setHttpMethodSpecify(true);
        //默认使用统一Web上下文 如果希望支持链路关系的流控策略则应该设置为false
        sentinelWebMvcConfig.setWebContextUnify(true);
        //用来标识来源 可针对性的对特定客户端的请求进行流控
        sentinelWebMvcConfig.setOriginParser(request -> request.getHeader("X-Client-Id"));
        registry.addInterceptor(new SentinelWebInterceptor(sentinelWebMvcConfig)).addPathPatterns("/**");
    }

}
