package org.example.test.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis配置
 * @Author yuzh
 * @Date 2023/2/19 19:55
 */
@Configuration
public class MybatisConfiguration {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        // 1、定义MP拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 2、添加具体的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
