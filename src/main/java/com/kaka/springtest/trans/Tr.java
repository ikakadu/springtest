package com.kaka.springtest.trans;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class Tr {
    public static void main(String[] args) throws Exception {
        Tr tr = new Tr();
        tr.updataServiceA();
    }

    public  void updataServiceA() throws Exception {
        System.out.println("A方法开始执行");
        updataServiceK();
        updataServiceM();
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updataServiceM() throws Exception {
        System.out.println("M方法开始执行");
        throw new Exception();
    }
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updataServiceK(){
        System.out.println("K方法开始执行");
    }
}
