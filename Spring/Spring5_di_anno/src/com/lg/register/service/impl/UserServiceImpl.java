package com.lg.register.service.impl;

import com.lg.register.dao.IUserDao;
import com.lg.register.domain.User;
import com.lg.register.service.IUserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Override
    public void registerUser(User user) {
        System.out.println("注册操作");
        dao.save(user);
    }
}
