package com.lg.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {

   @Autowired
   private MyDataSource myDataSource;

   @Test
    public void testOld() {
       MyDataSource ds = new MyDataSource();
       //立马对对象做初始化操作
       ds.open();

       ds.doWork();

       //在销毁之前执行扫尾操作
       ds.close();
   }

   @Test
   public void testIoc() {
      myDataSource.doWork();
   }
}
