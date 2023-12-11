package com.oracle.service;

import java.sql.SQLException;

import com.oracle.dao.HistoryDAO;
import com.oracle.dao.ProductDetailsViewDAO;
import com.oracle.logging.AppLogger;

public class DBService {
    private AppLogger logger = AppLogger.getInstance();

    public void getHelloWorld() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            HistoryDAO.getHelloWorld();
        } catch (SQLException e) {
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.logerror("Oracle JDBC Driver not found." + e.getMessage());
            e.printStackTrace();
        }
    }
    public void getHistoryAndPrint() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            HistoryDAO.getHistoryList();
            HistoryDAO.getHistorySampleDataDTOs();
        } catch (SQLException e) {
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.logerror("MySQL JDBC Driver not found." + e.getMessage());
            e.printStackTrace();
        }
    }
    public void getProductDetailsAndPring() throws SQLException, ClassNotFoundException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ProductDetailsViewDAO productDetailsViewDAO = new ProductDetailsViewDAO();
            productDetailsViewDAO.getProductDetailsDTOs();
        }catch(SQLException e){
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        }catch(ClassCastException e){
        }
    }
    public void getProductDetailsAndPringProcedure() throws SQLException, ClassNotFoundException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            ProductDetailsViewDAO productDetailsViewDAO = new ProductDetailsViewDAO();
            productDetailsViewDAO.getProductDetailsDTOsProcedure();
        }catch(SQLException e){
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        }catch(ClassCastException e){
        }
    }
}