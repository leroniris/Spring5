package com.lg.service.impl;

import com.lg.dao.IEmployeeDao;
import com.lg.domain.Employee;

public class EmployeeServiceImpl {

    private IEmployeeDao dao;

    public void setDao(IEmployeeDao dao) {
        this.dao = dao;
    }

    public void save(Employee employee) {
        dao.save(employee);
        System.out.println("保存成功");
    }

    public void update(Employee employee) {
        dao.update(employee);
        throw new RuntimeException("故意出错的");
    }
}
