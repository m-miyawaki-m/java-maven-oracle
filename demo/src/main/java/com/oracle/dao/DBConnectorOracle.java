package com.oracle.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.oracle.logging.AppLogger;

public class DBConnectorOracle {
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    // static initializer
    // 静的初期化ブロックは、クラスが初めてロードされるときに一度だけ実行
    static {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("/workspaces/java-oracle/demo/src/main/resources/application.properties")) {
            props.load(input);
            URL = props.getProperty("ORACLE_URL");
            USER = props.getProperty("ORACLE_USER");
            PASSWORD = props.getProperty("ORACLE_PASSWORD");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    // DBConnector.getConnection() is a static method, so we don't need to create an instance of DBConnector to use it.
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // HelloWorld!を表示する
    public static void getHelloWorld() throws SQLException{
        AppLogger logger = AppLogger.getInstance();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DBConnectorOracle.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT 'Hello World!' FROM dual");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.logerror("Oracle JDBC Driver not found." + e.getMessage());
            e.printStackTrace();
        }
    }

    
}