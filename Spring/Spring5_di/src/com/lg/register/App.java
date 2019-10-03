package com.lg.register;

import com.lg.register.action.UserAction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private UserAction action;

    @Test
    public void test() {
        action.execute();
    }
}
