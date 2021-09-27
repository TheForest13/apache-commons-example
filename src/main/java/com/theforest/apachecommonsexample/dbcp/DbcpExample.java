package com.theforest.apachecommonsexample.dbcp;



import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database connection pooling services.
 */
public class DbcpExample {
    private static BasicDataSource dataSource;

    private static BasicDataSource getDataSource() {

        if (dataSource == null) {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl("jdbc:postgresql://localhost:5432/dev");
            ds.setUsername("postgres");
            ds.setPassword("mysecretpassword");
            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);

            dataSource = ds;
        }
        return dataSource;
    }

    public static void main(String[] args) throws SQLException {

        try (BasicDataSource dataSource = DbcpExample.getDataSource();
             Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM bank_account");) {
            System.out.println("The Connection Object is of Class: " + connection.getClass());
            try (ResultSet resultSet = pstmt.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + ","
                            + resultSet.getString(2));
                }
            } catch (Exception e) {
                System.out.println("catch ??");
                connection.rollback();
                e.printStackTrace();
            }
        }
    }
}
