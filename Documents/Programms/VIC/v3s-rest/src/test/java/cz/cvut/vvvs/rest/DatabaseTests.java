/*
 * Copyright (c) 2019 Czech Technical University in Prague.
 * All Rights Reserved.
 */
package cz.cvut.vvvs.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * @author David Pavel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(VvvsRestApplication.class)
public class DatabaseTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void connectionTest() {
        new JdbcTemplate(dataSource).execute("SELECT 1 FROM DUAL");
    }
}
