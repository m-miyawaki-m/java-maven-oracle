package com.oracle.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.oracle.dao.AssetViewDAO;
import com.oracle.logging.AppLogger;
import com.oracle.model.AssetViewDTO;

public class AssetsDBService {
    private AppLogger logger = AppLogger.getInstance();

    public List<AssetViewDTO> getAssetViewDTOsTMP() throws SQLException, ClassNotFoundException{
        List<AssetViewDTO> assetDTOsTMP = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            AssetViewDAO assetViewDAO = new AssetViewDAO();
            assetDTOsTMP = assetViewDAO.getAssetViewDTOs().orElse(Collections.emptyList());
        }catch(SQLException e){
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        }catch(ClassCastException e){
        }
        return assetDTOsTMP;
    }

}