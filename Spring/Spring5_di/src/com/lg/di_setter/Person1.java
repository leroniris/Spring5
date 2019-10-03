package com.lg.di_setter;

public class Person1 {
    private Cat1 cat1;

    public void setCat1(Cat1 cat1) {
        this.cat1 = cat1;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "cat1=" + cat1 +
                '}';
    }
}
