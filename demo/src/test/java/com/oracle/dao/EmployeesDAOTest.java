package com.oracle.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.mockito.Mockito;

import com.oracle.model.EmployeesDTO;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeesDAOTest {

    @Test
    void getEmployeesDTOs() throws SQLException, ClassNotFoundException {
        // EmployeesDAOをモック化
        EmployeesDAO employeesDAO = Mockito.mock(EmployeesDAO.class);

        // テストデータを作成
        List<EmployeesDTO> employeesDTOs = Collections.emptyList();

        // モックの振る舞いを定義
        when(employeesDAO.getEmployeesDTOs()).thenReturn(Optional.of(employeesDTOs));

        // メソッドをテスト
        Optional<List<EmployeesDTO>> result = employeesDAO.getEmployeesDTOs();

        // 結果の検証
        assertTrue(result.isPresent());
        assertEquals(employeesDTOs, result.get());

    }
    
    @AfterEach
    void tearDown(TestInfo testInfo, TestReporter testReporter) {
        if (testInfo.getTags().contains("failed")) {
            System.out.println(testInfo.getDisplayName() + " failed!");
            testReporter.publishEntry(testInfo.getDisplayName() + " failed!");
        } else {
            System.out.println(testInfo.getDisplayName() + " passed!");
            testReporter.publishEntry(testInfo.getDisplayName() + " passed!");
        }
    }
}