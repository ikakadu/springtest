package com.kaka.springtest.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class JDBCTemplateSingletonDoubleCheck {
    @Autowired
    private static DataSource dataSource;



//    private static DataSource ds;



    private JDBCTemplateSingletonDoubleCheck(){}

    private static volatile JdbcTemplate jdbcTemplate;

    public static JdbcTemplate getInstance() {
        if (jdbcTemplate == null) {
            synchronized (JDBCTemplateSingletonDoubleCheck.class) {
                if (jdbcTemplate == null) {
                    jdbcTemplate = new JdbcTemplate(dataSource);
                }
            }
        }
        return jdbcTemplate;
    }
}
