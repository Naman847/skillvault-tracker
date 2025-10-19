package com.skillvault.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DbConnection {
    private static Connection connection=null;
    public static Connection getConnection(){
        if( connection != null)
            return connection;

        try (InputStream input = DbConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties props = new Properties();
            props.load(input);
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully!");
        } catch (IOException | SQLException e) {
            System.err.println(" DB Connection failed: " + e.getMessage());
        }

        return connection;
        }

}
