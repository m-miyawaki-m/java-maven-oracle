package com.oracle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.oracle.model.EmployeesDTO;

public class EmployeesDAO {
    public static Optional<List<EmployeesDTO>> getEmployeesDTOs() throws SQLException {
        List<EmployeesDTO> employeesDTOs = new ArrayList<>();
        try (Connection connection = DBConnectorOracle.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {

            while (resultSet.next()) {
                EmployeesDTO employee = new EmployeesDTO();
                employee.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setEmail(resultSet.getString("EMAIL"));
                employee.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
                employee.setHireDate(resultSet.getDate("HIRE_DATE"));
                employee.setJobId(resultSet.getString("JOB_ID"));
                employee.setSalary(resultSet.getDouble("SALARY"));
                employee.setCommissionPct(resultSet.getDouble("COMMISSION_PCT"));
                employee.setManagerId(resultSet.getInt("MANAGER_ID"));
                employee.setDepartmentId(resultSet.getInt("DEPARTMENT_ID"));

                employeesDTOs.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(employeesDTOs).isEmpty() ? null : Optional.of(employeesDTOs);
    }

    public static Optional<List<EmployeesDTO>> getEmployeesDTOsTMP() throws SQLException {
        List<EmployeesDTO> employeesDTOs = new ArrayList<>();
        try (Connection connection = DBConnectorOracle.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM tmp_employees")) {

            while (resultSet.next()) {
                EmployeesDTO employee = new EmployeesDTO();
                employee.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setEmail(resultSet.getString("EMAIL"));
                employee.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
                employee.setHireDate(resultSet.getDate("HIRE_DATE"));
                employee.setJobId(resultSet.getString("JOB_ID"));
                employee.setSalary(resultSet.getDouble("SALARY"));
                employee.setCommissionPct(resultSet.getDouble("COMMISSION_PCT"));
                employee.setManagerId(resultSet.getInt("MANAGER_ID"));
                employee.setDepartmentId(resultSet.getInt("DEPARTMENT_ID"));

                employeesDTOs.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(employeesDTOs).isEmpty() ? null : Optional.of(employeesDTOs);
    }
}
