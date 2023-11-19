package com.homura.myspringboot.config;

import com.homura.myspringboot.interceptor.mybatis.ExamplePlugin;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 注解方式mybatis配置类
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true, mode = AdviceMode.PROXY)
@MapperScan(basePackages = "com.homura.myspringboot.dao")
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            // 注册拦截器
            ExamplePlugin examplePlugin = new ExamplePlugin();
            configuration.addInterceptor(examplePlugin);
        };
    }
}
