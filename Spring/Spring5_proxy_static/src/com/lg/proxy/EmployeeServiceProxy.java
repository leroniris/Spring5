package com.lg.proxy;

import com.lg.domain.Employee;
import com.lg.service.IEmployeeService;
import com.lg.tx.TransactionManager;

public class EmployeeServiceProxy implements IEmployeeService {

    private IEmployeeService target;//真实对象/委托对象

    private TransactionManager txManager;//事务管理对象


    public void setTarget(IEmployeeService target) {
        this.target = target;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    @Override
    public void save(Employee employee) {
        txManager.begin();
        try{
            target.save(employee);
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManager.rollback();
        }
    }

    @Override
    public void update(Employee employee) {
        txManager.begin();
        try{
            target.update(employee);
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManager.rollback();
        }
    }
}
