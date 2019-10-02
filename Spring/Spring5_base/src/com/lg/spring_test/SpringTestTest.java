package com.lg.spring_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * SpringTest案例测试
 */
//运行Spring的jUnit5
@SpringJUnitConfig
public class SpringTestTest {

    @Autowired
    private SomeBean someBean;

    @Test
    public void testName() {
        someBean.doWork();
    }
}
