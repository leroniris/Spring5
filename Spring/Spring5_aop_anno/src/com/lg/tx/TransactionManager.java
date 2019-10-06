package com.lg.tx;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//模拟事务管理器：

//
// <!--AOP配置：在什么地点+什么时机+做什么-->
// <!--1、WHAT,做什么增强-->
// <bean id="txManager" class="com.lg.tx.TransactionManager"/>
// <!--设置为CGLIB代理-->
// <!--<aop:config proxy-target-class="true">-->
// <aop:config>
// <!--配置AOP切面-->
// <aop:aspect ref="txManager"><!--关联WHAT-->
// <!--2、WHERE,在哪些包中的的哪些类的哪些方法做增强-->
// <aop:pointcut id="txPoint" expression="execution(* com.lg.service.*Service.*(..))"/>
// <!--3、WHEN,在方法执行的什么时机做增强-->
// <!--<aop:before method="begin" pointcut-ref="txPoint"/>-->
// <!--<aop:after-returning method="commit" pointcut-ref="txPoint"/>-->
// <!--<aop:after-throwing method="rollback" pointcut-ref="txPoint" throwing="ex"/>-->
// <!--<aop:after method="release" pointcut-ref="txPoint"/>-->
// <aop:around method="aroundMethod" pointcut-ref="txPoint"/>
// </aop:aspect>
// </aop:config>
//
@Component
@Aspect
public class TransactionManager {

    //<aop:pointcut id="txPoint" expression="execution(* com.lg.service.*Service.*(..))"/>
    @Pointcut("execution(* com.lg.service.*Service.*(..))")
    public void txPoint() {

    }

    //<aop:before method="begin" pointcut-ref="txPoint"/>
//    @Before("txPoint()")
    public void begin() {
        System.out.println("开启事务");
    }

//    @AfterReturning("txPonit()")
    public void commit() {
        System.out.println("提交事务");
    }

//    @AfterThrowing(value = "txPoint()", throwing = "ex")
    public void rollback(Throwable ex) {
        System.out.println("回滚事务,异常信息" + ex.getMessage());
    }

//    @After("txPoint()")
    public void release() {
        System.out.println("释放资源");
    }

    @Around("txPoint()")
    public Object aroundMethod(ProceedingJoinPoint pjp) {
        Object ret = null;
        System.out.println("开启事务");
        try {
            ret = pjp.proceed();//调用真实对象的方法
//            int a = 1 / 0;
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务,异常信息=" + e.getMessage());
        } finally {
            System.out.println("释放资源");
        }
        return ret;
    }
}
