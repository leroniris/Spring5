package com.lg.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private SomeBean someBean1;

    @Autowired
    private SomeBean someBean2;

    @Test
    void test() {
        System.out.println(someBean1);
        System.out.println(someBean2);
        someBean1.doWork();
    }
}
