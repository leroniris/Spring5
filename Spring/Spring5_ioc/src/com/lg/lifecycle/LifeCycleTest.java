package com.lg.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    /**
     创建对象
     开启资源
     工作.......
     */
    @Test
    void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/lg/lifecycle/App-context.xml");
        MyDataSource ds = ctx.getBean("myDataSource", MyDataSource.class);
        ds.doWork();
        //加上以下这句会关闭资源
        ctx.close();
    }


    /**
     * 使用lombok
     */
    @Test
    void test2() {
//        @Cleanup
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/lg/lifecycle/App-context.xml");
        MyDataSource ds = ctx.getBean("myDataSource", MyDataSource.class);
        ds.doWork();
    }

    @Test
    void test3() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/lg/lifecycle/App-context.xml");
        MyDataSource ds = ctx.getBean("myDataSource", MyDataSource.class);
        ds.doWork();
        ctx.registerShutdownHook();
    }
}
