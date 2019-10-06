package com.lg.service;

import com.lg.domain.Employee;

public interface IEmployeeService {
    void save(Employee employee);

    void update(Employee employee);
}
