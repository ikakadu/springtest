package com.kaka.springtest.trans;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
public class JDBCTemplateSingletonStatic {

    @Resource
    DataSource ds;

    private static DataSource dataSource;

    @PostConstruct
    public void setDataSource(){
        JDBCTemplateSingletonStatic.dataSource = ds;
    }


    private JDBCTemplateSingletonStatic(){}

    private static class JdbcTemplateInstance {
        private static final JdbcTemplate INSTANCE = new JdbcTemplate(dataSource);
    }

    public static final JdbcTemplate getInstance() {
        return JdbcTemplateInstance.INSTANCE;
    }

}


