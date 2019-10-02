package com.lg.container;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
    //使用BeanFactory
    /**
     * 结论：BeanFactory有延时初始化（懒：lazy）的特点，在创建Spring容器的时候，不会立马去创建容器中管理的Bean对象，
     * 而是要等到从容器中去获取对象的时候，才去创建对象
     --------------------------------------------------
     构建Person...
     com.lg.container.Person@2473b9ce
     */
    @Test
    void testBeanFactory() {

        Resource resource = new ClassPathResource("com/lg/container/container.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("--------------------------------------------------");
        Person person = factory.getBean("person", Person.class);
        System.out.println(person);
    }

    //使用ApplicationContext
    /**
     * 在创建Spring容器的时候，就会把容器中管理的bean立马初始化，而不会等到获取bean的时候才初始化
     构建Person...
     --------------------------------------------------
     com.lg.container.Person@45dd4eda

     */
    @Test
    void testApplicationContext() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/lg/container/container.xml");
        System.out.println("--------------------------------------------------");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
    }
}
