package com.lg.container;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class ContainerTest {

    @Autowired
    private Person person;

    @Test
    public void test1() {
        System.out.println(person);
    }
}
