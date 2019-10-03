package com.lg.di_setter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private Employee1 employee1;

    @Autowired
    private Person1 person1;

    @Autowired
    private CollectionBean1 collectionBean1;
    @Test
    public void test() {
        System.out.println(employee1);
    }


    @Test
    public void test2() {
        System.out.println(person1);
    }

    @Test
    public void test3() {
        System.out.println(collectionBean1);
    }
}
