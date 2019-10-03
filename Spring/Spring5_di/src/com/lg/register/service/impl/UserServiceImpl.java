package com.lg.register.service.impl;

import com.lg.register.dao.IUserDao;
import com.lg.register.domain.User;
import com.lg.register.service.IUserService;
import lombok.Setter;

public class UserServiceImpl implements IUserService {

    @Setter
    private IUserDao dao;

    @Override
    public void registerUser(User user) {
        System.out.println("注册操作");
        dao.save(user);
    }
}
