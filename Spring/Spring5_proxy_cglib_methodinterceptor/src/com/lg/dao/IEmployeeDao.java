package com.lg.dao;

import com.lg.domain.Employee;

public interface IEmployeeDao {
    void save(Employee employee);

    void update(Employee employee);
}
