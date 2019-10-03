package com.lg.xml_autowire;

//需求：让Spring帮我们创建Person对象，而Person对象依赖于Dog对象
public class Person {
    private Dog dog;

    public Person() {

    }

    public Person(Dog dog) {
        this.dog = dog;
    }
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String toString() {
        return "Person  [dog=" + dog + "]";
    }
}
