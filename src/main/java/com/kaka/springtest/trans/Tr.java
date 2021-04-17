package com.kaka.springtest.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Tr {
    @Autowired
    Serv serv;

    /*@Transactional
    public  void updataServiceA() throws Exception {
        System.out.println("A方法开始执行");
        updataServiceK();
        updataServiceM();
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updataServiceM() throws Exception {
        System.out.println("M方法开始执行");
        serv.updateJob();
        throw new Exception();
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updataServiceK(){
        serv.updateEmployee();
        System.out.println("K方法开始执行");
    }*/
}
