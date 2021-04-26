package com.kaka.springtest;

import com.kaka.springtest.trans.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransTest {

    @Autowired
//    @Qualifier("myDbcp2DataSource")
    private DataSource dataSource;

    @Autowired
    Tr tr;

    @Autowired
    Serv serv;

    @Autowired
    MyRunable run;

    @Autowired
    ApplicationContext ac;


    @Test
    public void tt(){
        System.out.println("123123");
    }

    @Test
    public void jdbcTest1(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String queryStr = "select * from job";

        jdbcTemplate.query(queryStr, rs->{
            System.out.println(rs.getString("job_title"));
        });
    }

    @Test
    public void jdbcTest2(){
        String queryStr = "select * from job";
        final JdbcTemplate jdbcTemplate = JDBCTemplateSingletonStatic.getInstance();
        jdbcTemplate.query(queryStr, rs->{
            System.out.println(rs.getString("job_title"));
        });
    }


    @Test
    public void contextLoads() {
        System.out.println(ac);
    }



    @Test
    public void transSpreadTest(){
        System.out.println("开始transSpreadTest");
//        serv.updateSalary();
        new Thread(run,"num1").start();
//        new Thread(run,"num2").start();
//        new Thread(run,"num3").start();

    }
}
