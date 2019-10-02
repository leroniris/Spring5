package com.lg.spring_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringTest案例测试
 */
//运行Spring的jUnit4
@RunWith(SpringJUnit4ClassRunner.class)
//上下文配置对象（寻找配置文件的）
//@ContextConfiguration("classpath:com/lg/spring_test/springtest.xml")
//当使用@ContextConfiguration时，默认去找SpringTestTest-context.xml配置文件
@ContextConfiguration
public class SpringTestTest_juint4 {

    //表示自动按照类型去Spring容器中找到bean对象，并设置该字段
    @Autowired
    private SomeBean someBean;

    @Test
    public void testIoC() {
        //创建Spring的容器对象，再从容器对象中获取bean对象，再使用

        someBean.doWork();
    }
}
