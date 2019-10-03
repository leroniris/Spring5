package com.lg.register.dao.impl;

import com.lg.register.dao.IUserDao;
import com.lg.register.domain.User;
import lombok.Cleanup;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class IUserDaoImpl implements IUserDao {

    @Setter
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public void save(User user) {
        System.out.println("保存操作");
        @Cleanup
        Connection conn = dataSource.getConnection();
        String sql = "insert into user(name,age) values(?,?)";
        @Cleanup
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setInt(2, user.getAge());
        ps.execute();
    }
}
