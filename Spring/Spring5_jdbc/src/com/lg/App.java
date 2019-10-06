package com.lg;

import com.lg.dao.IEmployeeDao;
import com.lg.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private IEmployeeDao dao;

    @Test
    void testSave() {
        Employee e = new Employee();
        e.setName("乔峰");
        e.setAge(30);
        dao.save(e);
    }


    @Test
    void testUpdate() {
        Employee e = new Employee();
        e.setName("乔峰1");
        e.setAge(30);
        e.setId(5L);
        dao.update(e);
    }

    @Test
    void testDelete() {

        dao.delete(5L);
    }

}
