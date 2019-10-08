package com.lg.dao.impl;

import com.lg.dao.IEmployeeDao;
import com.lg.domain.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        List<Employee> list = jdbcTemplate.query("select id,name,age from employee where id=?", new Object[] {id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setName(rs.getString("name"));
                e.setAge(rs.getInt("age"));
                return e;
            }
        });
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<Employee> listAll() {
        return jdbcTemplate.query("select id,name,age  from employee", new Object[]{}, new RowMapper<Employee>() {
            //把每一行结果集映射成为一个对象
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setName(rs.getString("name"));
                e.setAge(rs.getInt("age"));
                return e;
            }
        });
    }
}
