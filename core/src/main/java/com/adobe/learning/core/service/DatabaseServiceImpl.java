package com.adobe.learning.core.service;

import com.day.commons.datasource.poolservice.DataSourcePool;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;

@Component(immediate = true, service = DatabaseService.class)
public class DatabaseServiceImpl implements DatabaseService {

    private final Logger logger = LoggerFactory.getLogger(DatabaseServiceImpl.class);

    @Reference
    private DataSourcePool dataSourcePool;

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            DataSource dataSource = (DataSource) dataSourcePool.getDataSource("aem_datasource");
            connection = dataSource.getConnection();
            logger.debug("Connection obtained");
        }
        catch (Exception e) {
            logger.debug("Unable to connect to database. Error message: " + e.getMessage());
        }
        return connection;
    }
}
/*
### SCRIPT ###

create database aem_db;
use aem_db;
create table user_table (user_name varchar(80), age int);

select * from user_table;
*/
