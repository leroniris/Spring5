package com.lg.di_constructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private Employee2 employee2;

    @Autowired
    private Person2 person2;

//    @Autowired
//    private Cat2 cat2;

    @Autowired
    private CollectionBean2 collectionBean2;
    @Test
    public void test() {
        System.out.println(employee2);
    }

    @Test
    public void test2() {
        System.out.println(person2);
//        System.out.println(cat2);
    }

    @Test
    public void test3() {
        System.out.println(collectionBean2);
    }
}
