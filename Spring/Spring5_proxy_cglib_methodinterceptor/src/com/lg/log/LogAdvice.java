package com.lg.log;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//日志增强
public class LogAdvice implements org.springframework.cglib.proxy.MethodInterceptor {

    private Object target;
    private LogUtil logUtil;

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setLogUtil(LogUtil logUtil) {
        this.logUtil = logUtil;
    }

    public <T> T getProxyObject() {
        /*
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
        */
        return (T) Enhancer.create(target.getClass(), this);
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        logUtil.writeLog(method.getDeclaringClass().getName(),method.getName());
        Object ret = null;
        ret = method.invoke(target, args);
        return ret;
    }
}
