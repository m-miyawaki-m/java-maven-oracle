package com.oracle;

import java.sql.SQLException;
import java.util.List;

import com.oracle.model.AssetViewDTO;
import com.oracle.service.AssetsDBService;
import com.oracle.service.DBService;
public class App {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        AssetsDBService assetsDBService = new AssetsDBService();
        try {
            // dbService.getHelloWorld();
            // dbService.getHistoryAndPrint();
            // dbService.getProductDetailsAndPring();
            // dbService.getProductDetailsAndPringProcedure();
            // boolean isSame = dbService.compareEmployeesDTOsAndEmployeesDTOsTMP();
            // System.out.println("isSame: " + isSame);
            List<AssetViewDTO> assetViewDTOs = assetsDBService.getAssetViewDTOsTMP();
            for (AssetViewDTO assetViewDTO : assetViewDTOs) {
                System.out.println(assetViewDTO);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
