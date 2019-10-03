package com.lg.xml_autowire;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private Person person;

    @Test
    public void test() {
        System.out.println(person);
    }

}
