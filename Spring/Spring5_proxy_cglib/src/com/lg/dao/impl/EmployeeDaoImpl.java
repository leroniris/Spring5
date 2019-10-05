package com.lg.dao.impl;

import com.lg.dao.IEmployeeDao;
import com.lg.domain.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
    @Override
    public void save(Employee employee) {
        System.out.println("保存员工");
    }

    @Override
    public void update(Employee employee) {
        System.out.println("修改员工");
    }
}
