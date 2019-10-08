package com.lg;

import com.lg.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes=AppConfig.class)
public class App {

	@Autowired
	private IAccountService service;

	@Test
	void testTrans() throws Exception {
		service.trans(10086L, 10010L, 1000);
	}
}
