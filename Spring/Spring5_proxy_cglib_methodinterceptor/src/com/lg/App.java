package com.lg;

import com.lg.domain.Employee;
import com.lg.log.LogAdvice;
import com.lg.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private LogAdvice advice;

    @Test
    void testSave() {
        EmployeeServiceImpl proxy = advice.getProxyObject();
        proxy.save(new Employee());
    }


    @Test
    void testUpdate() {
        EmployeeServiceImpl proxy = advice.getProxyObject();
        proxy.update(new Employee());
    }
}
