package org.example.test.log;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author yuzh
 * @Date 2023/2/20 22:31
 */
@Component
@WebFilter(filterName = "traceIdFilter", urlPatterns = "/*")
public class TraceIdFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            MDC.put("traceId", UUID.randomUUID().toString().replace("-", ""));
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove("traceId");
        }
    }
}
