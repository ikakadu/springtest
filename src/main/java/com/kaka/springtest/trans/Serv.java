package com.kaka.springtest.trans;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Serv {

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateSalary(){
        String sql = "update salary set salary = 22  where  emp_id = 1";
        final JdbcTemplate jdbcTemplate = JDBCTemplateSingletonStatic.getInstance();
        jdbcTemplate.update(sql);

        updateEmployee();
//        updateJob();

        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateEmployee() {
        String sql = "update employee set name = '李白1'  where  id = 1";
        final JdbcTemplate jdbcTemplate = JDBCTemplateSingletonStatic.getInstance();
        jdbcTemplate.update(sql);
//        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.REQUIRED)
    public void updateJob() {
        String sql = "update job set job_title = '开发工程师1'  where  job_id = 1";
        final JdbcTemplate jdbcTemplate = JDBCTemplateSingletonStatic.getInstance();
        jdbcTemplate.update(sql);
//        throw new RuntimeException();
    }



}
