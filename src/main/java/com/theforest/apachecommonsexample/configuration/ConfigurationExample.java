package com.theforest.apachecommonsexample.configuration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

/**
 * Reading of configuration/preferences files in various formats.
 */
public class ConfigurationExample {
    public static void main(String[] args) {
        Configurations configs = new Configurations();
        try
        {
            Configuration config = configs.properties(new File("database.properties"));
            String dbHost = config.getString("database.host");
            System.out.println(dbHost);
            int dbPort = config.getInt("database.port");
            System.out.println(dbPort);
            String dbUser = config.getString("database.user");
            System.out.println(dbUser);
            String dbPassword = config.getString("database.password", "secret");  // provide a default
            System.out.println(dbPassword);
            long dbTimeout = config.getLong("database.timeout");
            System.out.println(dbTimeout);

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
