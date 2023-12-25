package com.oracle.model;

import lombok.Data;
import java.util.Date;

@Data
public class EmployeesDTO {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private double salary;
    private double commissionPct;
    private int managerId;
    private int departmentId;
}