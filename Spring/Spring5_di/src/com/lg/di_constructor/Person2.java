package com.lg.di_constructor;

public class Person2 {
    private Cat2 cat2;

    public Person2(Cat2 cat2) {
        this.cat2 = cat2;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "cat2=" + cat2 +
                '}';
    }
}
