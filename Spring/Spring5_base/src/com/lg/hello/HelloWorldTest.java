package com.lg.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

public class HelloWorldTest {

    //传统方式,正控:调用者手动来创建对象,和创建对象依赖的的对象,并组装依赖关系
    @Test
    public void testOld() throws Exception{
        //创建一个对象
        HelloWorld world = new HelloWorld();
        //给当前对象设置相关的依赖属性
        world.setUsername("will");
        world.setAge(17);
        world.sayHello();
    }

    //使用Spring框架之后
    @Test
    public void testIoC() throws Exception{
        HelloWorld world = null;

        //1、从classpath路径下寻找配置文件，创建资源对象
        Resource resource = new ClassPathResource("applicationContext.xml");
        //2、据资源对象,创建Spring IoC容器对象
        BeanFactory factory = new XmlBeanFactory(resource);
        //3:从Spring IoC容器中获取指定名称(helloWorld)的对象
        //签名一：Object getBean(String beanName);根据bean对象在容器中的名称获取
        //world = (HelloWorld) factory.getBean("helloWorld");
        //签名二：<T> T getBean(Class<T> var1);按照指定类型去寻找bean对象
        //world = factory.getBean(HelloWorld.class);
        //签名三：<T> T getBean(String var1, @Nullable Class<T> var2);根据bean类型+ID名称去寻找,推荐此方法
        world = factory.getBean("helloWorld", HelloWorld.class);

        world.sayHello();
    }

    //模拟Spring IoC容器操作
    @Test
    void testIoCMock() throws Exception {
        String className = "com.lg.hello.HelloWorld";

        HelloWorld world = null;

        //使用反射创建对象
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor();
        //设置构造器可以访问
        constructor.setAccessible(true);
        Object obj = constructor.newInstance();

        //使用内省机制设置属性值
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor pd : pds) {
            //HelloWorld类中所有属性名称
            String propertyName = pd.getName();
            if("username".equals(propertyName)) {
                //调用username的setter方法
                pd.getWriteMethod().invoke(obj, "Lucy");
            } else if ("age".equals(propertyName)) {
                //调用age的setter方法
                pd.getWriteMethod().invoke(obj, 18);
            }
        }

        world = (HelloWorld) obj;

        world.sayHello();
    }

}
