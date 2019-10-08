package com.lg.dao.impl;

import com.lg.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AccountDaoImpl implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void transOut(Long outId, int money) {
        jdbcTemplate.update("UPDATE account set balance = balance - ? where id = ?", money, outId);
    }

    @Override
    public void transIn(Long inId, int money) {
        jdbcTemplate.update("UPDATE account set balance = balance + ? where id = ?", money, inId);

    }
}
