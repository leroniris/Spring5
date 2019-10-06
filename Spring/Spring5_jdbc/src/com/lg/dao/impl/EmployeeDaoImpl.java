package com.lg.dao.impl;

import com.lg.dao.IEmployeeDao;
import com.lg.domain.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


public class EmployeeDaoImpl implements IEmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Employee employee) {
        this.jdbcTemplate.update("insert into employee(name,age) values(?, ?)", employee.getName(), employee.getAge());
    }

    @Override
    public void update(Employee employee) {
        this.jdbcTemplate.update("UPDATE employee SET name = ?,age = ? WHERE id= ?", employee.getName(), employee.getAge(),
                employee.getId());
    }

    @Override
    public void delete(Long id) {
        this.jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);
    }

    @Override
    public Employee get(Long id) {
        return null;
    }

    @Override
    public List<Employee> listAll() {
        return null;
    }
}
