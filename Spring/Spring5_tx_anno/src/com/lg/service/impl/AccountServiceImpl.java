package com.lg.service.impl;

import com.lg.dao.IAccountDao;
import com.lg.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao dao;


    @Override
    public void trans(Long outId, Long inId, int money) {
        dao.transOut(outId, money);
        int a = 1 / 0;
        dao.transIn(inId, money);
    }
}
