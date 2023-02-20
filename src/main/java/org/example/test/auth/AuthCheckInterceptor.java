package org.example.test.auth;

import org.example.test.config.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yuzh
 * @Date 2023/2/20 22:15
 */

public class AuthCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private TestProperties testProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从header中获取token
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)) {
            throw new ServletException("token不能为空");
        }
        if(!token.equals(testProperties.getToken())) {
            throw new ServletException("token无效");
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
