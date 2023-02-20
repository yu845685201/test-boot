package org.example.test.auth;

import org.example.test.config.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author yuzh
 * @Date 2023/2/20 22:03
 */
//@Component
//@WebFilter(filterName = "authCheckFilter", urlPatterns = "/*")
public class AuthCheckFilter implements Filter {

    @Autowired
    private TestProperties testProperties;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 从header中获取token
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)) {
            throw new ServletException("token不能为空");
        }
        if(!token.equals(testProperties.getToken())) {
            throw new ServletException("token无效");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
