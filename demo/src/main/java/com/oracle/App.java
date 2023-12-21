package com.oracle;

import java.sql.SQLException;

import com.oracle.service.DBService;
public class App {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        try {
            // dbService.getHelloWorld();
            // dbService.getHistoryAndPrint();
            dbService.getProductDetailsAndPring();
            dbService.getProductDetailsAndPringProcedure();
            boolean isSame = dbService.compareEmployeesDTOsAndEmployeesDTOsTMP();
            System.out.println("isSame: " + isSame);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
