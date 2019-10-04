package com.lg.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

    private Cat cat;

    @Autowired
    @Qualifier("cat")
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                '}';
    }
}
