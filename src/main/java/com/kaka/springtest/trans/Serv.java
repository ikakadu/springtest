package com.kaka.springtest.trans;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
//@EnableTransactionManagement(proxyTargetClass = true)
//@EnableAspectJAutoProxy(exposeProxy = true)
public class Serv {
    @Transactional(propagation = Propagation.REQUIRED)
    public synchronized void updateSalary(){
        System.out.println("调用updateSalary");
        String sql = "update salary set salary = salary+1  where  emp_id = 1";
        final JdbcTemplate jdbcTemplate = JDBCTemplateSingletonStatic.getInstance();
        jdbcTemplate.update(sql);

//        Serv s = (Serv) AopContext.currentProxy();
//        s.updateEmployee();

        updateEmployee();
//        updateJob();
        System.out.println("调用结束");
//        throw new RuntimeException();
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
