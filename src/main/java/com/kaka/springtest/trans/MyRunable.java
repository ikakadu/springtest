package com.kaka.springtest.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRunable implements Runnable{
    @Autowired
    Serv serv;

    @Override
    public void run() {
        try {
            serv.updateSalary();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}