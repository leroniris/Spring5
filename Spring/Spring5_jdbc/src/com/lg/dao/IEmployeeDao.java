package com.lg.dao;

import com.lg.domain.Employee;

import java.util.List;

public interface IEmployeeDao {
    void save(Employee employee);

    void update(Employee employee);

    void delete(Long id);

    Employee get(Long id);

    List<Employee> listAll();
}
