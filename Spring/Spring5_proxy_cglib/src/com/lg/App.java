package com.lg;

import com.lg.domain.Employee;
import com.lg.service.impl.EmployeeServiceImpl;
import com.lg.tx.TransactionManagerAdvice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private TransactionManagerAdvice advice;

    //CGLIB代理对象com.lg.service.impl.EmployeeServiceImpl$$EnhancerByCGLIB$$eaab6de3
    @Test
    void testSave() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"C:/test");
        EmployeeServiceImpl proxy = advice.getProxyObject();
        proxy.save(new Employee());
//        System.out.println(proxy.getClass());
    }

    @Test
    void testUpdate() {
        EmployeeServiceImpl proxy = advice.getProxyObject();
        proxy.update(new Employee());
    }
}
