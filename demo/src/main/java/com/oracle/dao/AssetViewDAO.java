package com.oracle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.oracle.model.AssetViewDTO;

public class AssetViewDAO {
    
    public Optional<List<AssetViewDTO>> getAssetViewDTOs() throws SQLException {
        List<AssetViewDTO> assetViewDTOs = new ArrayList<>();
        try (Connection connection = DBConnectorOracle.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM ASSET_MANAGEMENT_FILTERED_VIEW")) {

            while (resultSet.next()) {
                AssetViewDTO assetView = new AssetViewDTO();
                assetView.setAssetClassification(resultSet.getString("ASSET_CLASSIFICATION"));
                assetView.setAcquisitionDate(resultSet.getDate("ACQUISITION_DATE"));
                assetView.setAcquisitionCost(resultSet.getFloat("ACQUISITION_COST"));

                assetViewDTOs.add(assetView);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return Optional.ofNullable(assetViewDTOs);
    }
}
