package com.lg.service.impl;

import com.lg.dao.IEmployeeDao;
import com.lg.domain.Employee;
import com.lg.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao dao;

    public void save(Employee employee) {
        dao.save(employee);
        System.out.println("保存成功");
    }

    public void update(Employee employee) {
        dao.update(employee);
        throw new RuntimeException("故意出错的");
    }
}
