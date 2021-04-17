package com.kaka.springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransTest {

    @Autowired
//    @Qualifier("myDbcp2DataSource")
    private DataSource dataSource;

    @Test
    public void tt(){
        System.out.println("123123");
    }

    @Test
    public void f(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String queryStr = "select * from job";

        jdbcTemplate.query(queryStr, rs->{
            System.out.println(rs.getString("job_title"));
        });
    }

}