package com.homura.myspringboot.spi.impl;

import com.homura.myspringboot.spi.TestSpiInterface;

/**
 * 实现类，可以是多个，可以不是本工程或者包，允许从第三方jar包中获取
 */
public class TestSpiInterfaceA implements TestSpiInterface {
    @Override
    public void test() {
        System.out.println("TestSpiInterfaceA");
    }
}
