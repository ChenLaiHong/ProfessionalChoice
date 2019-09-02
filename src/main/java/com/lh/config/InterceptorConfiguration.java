package com.lh.config;

import com.lh.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Description: 配置拦截器,让拦截器生效</p>
 *
 */
@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 只拦截学生选报方向模块的请求
        registry.addInterceptor(loginInterceptor).addPathPatterns("/task/**");
    }
}
