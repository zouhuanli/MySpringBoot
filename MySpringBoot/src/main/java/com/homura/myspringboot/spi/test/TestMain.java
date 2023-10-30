package com.homura.myspringboot.spi.test;

import com.homura.myspringboot.spi.TestSpiInterface;

import java.util.ServiceLoader;

public class TestMain {
    public static void main(String[] args) {
        // 通过ServiceLoader加载实现类
        ServiceLoader<TestSpiInterface> serviceLoader = ServiceLoader.load(TestSpiInterface.class);
        for (TestSpiInterface testSpiInterface : serviceLoader) {
            testSpiInterface.test();
        }
    }
}
