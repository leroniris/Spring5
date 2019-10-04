package com.lg.lifecycle;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//XML配置：<bean id="someBean" class="com.lg.lifecycle.SomeBean"
//        init-method="open" destroy-method="close" scope="singleton"/>
//注解配置：
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope("singleton")
public class SomeBean {
    public SomeBean() {
        System.out.println("构建SomeBean对象");
    }

    @PostConstruct//构建对象之后
    public void open() {
        System.out.println("初始化方法");
    }

    @PreDestroy//销毁之前
    public void close() {
        System.out.println("销毁方法");
    }

    public void doWork(){
        System.out.println("工作");
    }
}
