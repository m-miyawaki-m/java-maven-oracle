package com.oracle;

import java.sql.SQLException;

import com.oracle.service.DBService;
public class App {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        try {
            dbService.getHelloWorld();
            dbService.getHistoryAndPrint();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
