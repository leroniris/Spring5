package com.lg.service.impl;

import com.lg.dao.IAccountDao;
import com.lg.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao dao;

    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    @Override
    public void trans(Long outId, Long inId, int money) {
        dao.transOut(outId, money);
        int a = 1 / 0;
        dao.transIn(inId, money);
    }
}
