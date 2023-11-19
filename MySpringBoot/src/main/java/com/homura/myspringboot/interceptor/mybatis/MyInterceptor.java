package com.homura.myspringboot.interceptor.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class MyInterceptor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(com.homura.myspringboot.interceptor.mybatis.ExamplePlugin.class);
    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // implement pre processing if need
        LOGGER.info("MyInterceptor intercept preprocessing");
        Object returnObject = invocation.proceed();
        // implement post processing if need
        LOGGER.info("MyInterceptor intercept postprocessing");
        return returnObject;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}

