package org.example.test.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置类，对应于application配置文件中的自定义配置信息
 * @Author yuzh
 * @Date 2023/2/19 16:16
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "test")
public class TestProperties {
    private String message;
}
