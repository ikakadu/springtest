package com.kaka.springtest.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
public class JDBCTemplateSingletonDoubleCheck {
    @Autowired
    private  DataSource dataSource;



    private static DataSource ds;

    @PostConstruct
    private void setDataSource(){
        ds = dataSource;
    }



    private JDBCTemplateSingletonDoubleCheck(){}

    private static volatile JdbcTemplate jdbcTemplate;

    public static JdbcTemplate getInstance() {
        if (jdbcTemplate == null) {
            synchronized (JDBCTemplateSingletonDoubleCheck.class) {
                if (jdbcTemplate == null) {
                    jdbcTemplate = new JdbcTemplate(ds);
                }
            }
        }
        return jdbcTemplate;
    }
}
