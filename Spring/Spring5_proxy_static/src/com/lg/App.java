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
        service.save(new Employee());
    }

    @Test
    void testUpdate() {
        service.update(new Employee());
    }
}
