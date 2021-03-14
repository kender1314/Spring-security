package com.example.demo.configure;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 注意：spring容器托管的filter的bean，都会自动加入到servlet的filter chain。
 * 使用spring security过程中，自定义的filter被重复执行，一次是在Spring Security的过滤链中被执行，另一次是在servlet过滤链中执行。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/11 17:27
 */
@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("初始化MyFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行MyFilter");
    }

    @Override
    public void destroy() {
        System.out.println("销毁MyFilter");
    }
}
