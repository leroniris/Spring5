package com.lg.bean_tag_inheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private SomeBean1 someBean1;

    @Autowired
    private SomeBean2 someBean2;

    @Test
    public void test() {
        System.out.println(someBean1);
        System.out.println(someBean2);
    }
}
