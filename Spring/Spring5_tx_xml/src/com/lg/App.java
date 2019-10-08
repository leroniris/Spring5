package com.lg;

import com.lg.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

    @Autowired
    private IAccountService service;

    @Test
    public void testTrans() {
        service.trans(10086L, 10010L, 1000);
    }
}
