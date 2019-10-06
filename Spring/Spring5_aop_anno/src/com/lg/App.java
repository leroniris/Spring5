package com.lg;

import com.lg.domain.Employee;
import com.lg.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private IEmployeeService service;

    @Test
    void testSave() {
        System.out.println(service.getClass());
        service.save(new Employee());
    }


    @Test
    void testUpdate() {
        System.out.println(service.getClass());
        service.update(new Employee());
    }
}
