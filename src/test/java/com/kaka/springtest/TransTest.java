package com.kaka.springtest;

import com.kaka.springtest.trans.JDBCTemplateSingletonDoubleCheck;
import com.kaka.springtest.trans.JDBCTemplateSingletonStatic;
import com.kaka.springtest.trans.Serv;
import com.kaka.springtest.trans.Tr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void transSpreadTest(){
        serv.updateSalary();
    }

    @Autowired
    ApplicationContext ac;

    @Test
    public void contextLoads() {
        System.out.println(ac);
    }

}