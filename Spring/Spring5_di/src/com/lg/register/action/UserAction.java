package com.lg.register.action;

import com.lg.register.domain.User;
import com.lg.register.service.IUserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

//模拟Struct2的Action/SpringMVC的Controller
public class UserAction {

    @Setter
    private IUserService service;

    public String execute() {
        System.out.println("注册请求");
        service.registerUser(new User());
        return "success";
    }
}
