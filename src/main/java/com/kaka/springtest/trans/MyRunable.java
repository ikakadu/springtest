package com.kaka.springtest.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyRunable implements Runnable{
    @Autowired
    Serv serv;

    @Override
    public void run() {
        try {
//            serv.updateSalary();

//            String sql = "update salary set salary = salary+1  where  emp_id = 1";
//            final JdbcTemplate jdbcTemplate = JDBCTemplateSingletonStatic.getInstance();
//            jdbcTemplate.update(sql);
            String queryStr = "select * from job";
            final JdbcTemplate jdbcTemplate = JDBCTemplateSingletonStatic.getInstance();
            jdbcTemplate.query(queryStr, rs->{
                System.out.println(rs.getString("job_title"));
            });
            System.out.println("执行暂时结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}