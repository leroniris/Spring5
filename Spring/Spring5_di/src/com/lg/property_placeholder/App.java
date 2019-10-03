package com.lg.property_placeholder;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringJUnitConfig
public class App {

    @Autowired
    private DataSource ds;

    @Test
    public void test() throws Exception {

//        ds = new DruidDataSource();
//        ((DruidDataSource) ds).setDriverClassName("com.mysql.jdbc.Driver");
//        ((DruidDataSource) ds).setUrl("jdbc:mysql://localhost:3306/springdemo");
//        ((DruidDataSource) ds).setUsername("root");
//        ((DruidDataSource) ds).setPassword("ligan1998");
//        ((DruidDataSource) ds).setInitialSize(2);
        @Cleanup
        Connection conn = ds.getConnection();
        @Cleanup
        PreparedStatement ps = conn.prepareStatement("select id,name,age from student");
        @Cleanup
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            System.out.print(rs.getLong("id") + ", ");
            System.out.print(rs.getString("name") + ", ");
            System.out.println(rs.getInt("age"));
        }

    }
}
