package com.lg.createbean;

import com.lg.createbean._01_constructor.Cat1;
import com.lg.createbean._02_static_factory.Cat2;
import com.lg.createbean._02_static_factory.Cat2Factory;
import com.lg.createbean._03_instance_factory.Cat3;
import com.lg.createbean._03_instance_factory.Cat3Factory;
import com.lg.createbean._04_factory_bean.Cat4;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private Cat1 cat1;

    @Autowired
    private Cat2 cat2;

    @Autowired
    private Cat3 cat3;

    @Autowired
    private Cat4 cat4;

    @Test
    void testOld() {
        //方式一：构造器
        Cat1 c1 = new Cat1();

        //方式二：静态工厂方法
        Cat2 c2 = Cat2Factory.createInstance();

        //方式三：实例工厂方法
        Cat3 c3 = new Cat3Factory().createInstance();
    }

    @Test
    void test() {
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat4);
    }
}
