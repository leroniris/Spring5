package com.lg.dao.impl;

import com.lg.dao.IAccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class AccountDaoImpl implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

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
