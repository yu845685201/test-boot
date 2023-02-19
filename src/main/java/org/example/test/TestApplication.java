package org.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot启动类
 * @Author yuzh
 * @Date 2023/2/19 16:01
 */
// springboot启动类注解
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        // 启动springboot项目，固定写法
        SpringApplication.run(TestApplication.class, args);
    }
}
