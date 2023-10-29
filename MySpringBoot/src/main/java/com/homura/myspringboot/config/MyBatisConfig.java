package com.homura.myspringboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 注解方式mybatis配置类
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true, mode = AdviceMode.PROXY)
@MapperScan(basePackages = "com.homura.myspringboot.dao")
public class MyBatisConfig {
}
