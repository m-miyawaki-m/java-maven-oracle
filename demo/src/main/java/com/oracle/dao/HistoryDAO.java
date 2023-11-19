package com.oracle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oracle.model.SampleDataDTO;

public class HistoryDAO {
        public static List<String> getHistoryList() throws SQLException {
        Connection connection = DBConnectorOracle.getConnection();
        List<String> history = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT sampleinput FROM dev_history");

            while (resultSet.next()) {
                String sampleInput = resultSet.getString("sampleinput");
                history.add(sampleInput);
                System.out.println(sampleInput);
            }
        } finally {
            connection.close();
        }
        return history;
    }
    public static List<SampleDataDTO> getHistorySampleDataDTOs() throws SQLException {
        List<SampleDataDTO> history = new ArrayList<>();
        try (Connection connection = DBConnectorOracle.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM dev_history")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("No");
                String sampleInput = resultSet.getString("sampleinput");
                history.add(new SampleDataDTO(id, sampleInput));
                System.out.println("No:" + id + " sampleInput:" + sampleInput);
            }
            //test用に例外を発生させる
            //throw new SQLException("SQLエラーが発生しました。");
        } catch (SQLException e) {
            // 例外処理をここに書く
            e.printStackTrace();
        }
        return history;
    }
}
