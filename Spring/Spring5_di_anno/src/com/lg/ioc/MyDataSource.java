package com.lg.ioc;

import org.springframework.stereotype.Component;

//XML配置：<bean id="myDataSource" class="com.lg.ioc.MyDataSource"/>
//注解配置：@Component
@Component("myDataSource")//组件如果不写value属性值,此时bean的id默认是类型首字母小写:myDataSource
public class MyDataSource {
}
