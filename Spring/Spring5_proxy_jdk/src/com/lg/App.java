package com.lg;

import com.lg.domain.Employee;
import com.lg.service.IEmployeeService;
import com.lg.tx.TransactionManagerAdvice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private TransactionManagerAdvice advice;

    @Test
    void testSave() {
        //获取代理对象
        IEmployeeService proxy = advice.getProxyObject();
        proxy.save(new Employee());
    }

    @Test
    void testUpdate() {
        //获取代理对象
        IEmployeeService proxy = advice.getProxyObject();
        proxy.update(new Employee());
    }
}
