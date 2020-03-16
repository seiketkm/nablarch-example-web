package com.nablarch.example.app.dbunit;

import com.zaxxer.hikari.HikariDataSource;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceInitializer {

    static final DataSource ds = create();

    private static DataSource create() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setJdbcUrl("jdbc:h2:./h2/db/nablarch_example;DATABASE_TO_UPPER=false");
        ds.setUsername("NABLARCH_EXAMPLE");
        ds.setPassword("NABLARCH_EXAMPLE");
        return ds;
    }

    static Connection getJdbcConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static DatabaseConnection getDatabaseConnection() {
        Connection jdbcConn = getJdbcConnection();
        try {
            return new DatabaseConnection(jdbcConn);
        } catch (DatabaseUnitException e) {
            throw new RuntimeException(e);
        }
    }

}
