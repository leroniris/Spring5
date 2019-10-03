package com.lg.di_constructor;

import java.math.BigDecimal;

public class Employee2 {
    private String name;
    private Integer age;
    private BigDecimal salary;

    public Employee2(String name, Integer age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
