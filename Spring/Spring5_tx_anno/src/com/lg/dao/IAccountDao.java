package com.lg.dao;

public interface IAccountDao {
    /**
     * 从指定账户转出多少钱
     * @param outId
     * @param money
     */
    void transOut(Long outId, int money);

    /**
     * 从指定账户转入多少钱
     * @param InId
     * @param money
     */
    void transIn(Long InId, int money);
}
