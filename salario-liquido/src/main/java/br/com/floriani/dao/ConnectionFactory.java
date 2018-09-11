package br.com.floriani.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionFactory {

    private static ConnectionFactory datasource;
    private final ComboPooledDataSource cpds;

    private ConnectionFactory() throws IOException, SQLException, PropertyVetoException {

        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver");
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/rh");
        cpds.setUser("postgres");
        cpds.setPassword("123456"); //a123456*

        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(150);

    }

    public static ConnectionFactory getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new ConnectionFactory();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

}
