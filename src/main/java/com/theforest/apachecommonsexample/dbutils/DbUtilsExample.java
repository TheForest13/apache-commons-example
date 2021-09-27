package com.theforest.apachecommonsexample.dbutils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * JDBC helper library.
 */
public class DbUtilsExample {

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
        // Create a ResultSetHandler implementation to convert the
        // first row into an Object[].
        ResultSetHandler<Object[]> h = new ResultSetHandler<Object[]>() {
            public Object[] handle(ResultSet rs) throws SQLException {
                if (!rs.next()) {
                    return null;
                }

                ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();
                Object[] result = new Object[cols];

                for (int i = 0; i < cols; i++) {
                    result[i] = rs.getObject(i + 1);
                }

                return result;
            }
        };

// Create a QueryRunner that will use connections from
// the given DataSource
        QueryRunner run = new QueryRunner(getDataSource());

// Execute the query and get the results back from the handler
        Object[] result = run.query(
                "SELECT * FROM bank_account WHERE uid=?", h, "uid1");
        System.out.println(result[0]);
    }
}
