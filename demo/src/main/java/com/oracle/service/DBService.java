package com.oracle.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.oracle.dao.EmployeesDAO;
import com.oracle.dao.HistoryDAO;
import com.oracle.dao.ProductDetailsViewDAO;
import com.oracle.logging.AppLogger;
import com.oracle.model.EmployeesDTO;

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
    
    public List<EmployeesDTO> getEmployeesDTOs() throws SQLException, ClassNotFoundException{
        List<EmployeesDTO> employeesDTOs = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            employeesDTOs = EmployeesDAO.getEmployeesDTOs().orElse(Collections.emptyList());
        }catch(SQLException e){
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        }catch(ClassCastException e){
        }
        return employeesDTOs;
    }

    public List<EmployeesDTO> getEmployeesDTOsTMP() throws SQLException, ClassNotFoundException{
        List<EmployeesDTO> employeesDTOsTMP = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            employeesDTOsTMP = EmployeesDAO.getEmployeesDTOsTMP().orElse(Collections.emptyList());
        }catch(SQLException e){
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        }catch(ClassCastException e){
        }
        return employeesDTOsTMP;
    }

    public boolean compareEmployeesDTOsAndEmployeesDTOsTMP() throws SQLException, ClassNotFoundException{
        boolean isSame = false;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            List<EmployeesDTO> employeesDTOs = EmployeesDAO.getEmployeesDTOs().orElse(Collections.emptyList());
            List<EmployeesDTO> employeesDTOsTMP = EmployeesDAO.getEmployeesDTOsTMP().orElse(Collections.emptyList());
            isSame = employeesDTOs.equals(employeesDTOsTMP);
        }catch(SQLException e){
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        }catch(ClassCastException e){
        }
        return isSame;
    }


}