package org.example.test.config;

import org.example.test.auth.AuthCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author yuzh
 * @Date 2023/2/20 22:18
 */
@Configuration
public class TestMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        AuthCheckInterceptor authCheckInterceptor = authCheckInterceptor();
        String[] path = {"/**"};
        registry.addInterceptor(authCheckInterceptor)
                .addPathPatterns(path);
    }

    @Bean
    public AuthCheckInterceptor authCheckInterceptor() {
        return new AuthCheckInterceptor();
    }
}
