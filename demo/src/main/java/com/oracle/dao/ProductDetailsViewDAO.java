package com.oracle.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oracle.model.ProductDetailsDTO;

import oracle.jdbc.OracleTypes;

public class ProductDetailsViewDAO {
    public List<ProductDetailsDTO> getProductDetailsDTOs() throws SQLException {
        List<ProductDetailsDTO> products = new ArrayList<>();
        String sql = null;
        String sqlFilePath = "/workspaces/java-maven-oracle/demo/src/main/resources/sql/SELECT_ALL_PRODUCT_DETAILS_VIEW.sql";
        try {
            sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(sql != null){
        try (Connection connection = DBConnectorOracle.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                ProductDetailsDTO product = new ProductDetailsDTO();
                product.setProductCode(getNullableLong(resultSet, "PRODUCT_CODE"));
                product.setProductCategoryName(getNullableString(resultSet, "PRODUCT_CATEGORY_NAME"));
                product.setProductName(getNullableString(resultSet, "PRODUCT_NAME"));
                product.setUnitPrice(getNullableLong(resultSet, "UNIT_PRICE"));
                product.setLastArrivalDate(resultSet.getDate("LAST_ARRIVAL_DATE")); // Date型はwasNullチェック不要
                product.setModelNumber(getNullableString(resultSet, "MODEL_NUMBER"));
                product.setDiscountedPrice(getNullableLong(resultSet, "DISCOUNTED_PRICE"));
            
                products.add(product);
            
                // デバッグ用の出力
                System.out.println("Product Code: " + product.getProductCode() + ", Product Name: " + product.getProductName());
            }
            //test用に例外を発生させる
            //throw new SQLException("SQLエラーが発生しました。");
        } catch (SQLException e) {
            // 例外処理をここに書く
            e.printStackTrace();
        }
        }
        return products;
    }
    private Long getNullableLong(ResultSet rs, String columnName) throws SQLException {
        Long value = rs.getObject(columnName, Long.class);
        return rs.wasNull() ? null : value;
    }
    
    private String getNullableString(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return rs.wasNull() ? null : value;
    }
    public List<ProductDetailsDTO> getProductDetailsDTOsProcedure() throws SQLException {
        List<ProductDetailsDTO> products = new ArrayList<>();
        String condition = "Even"; // or "Odd"

        try (Connection connection = DBConnectorOracle.getConnection();
            CallableStatement stmt = connection.prepareCall("{call select_product_codes(?, ?)}")) {
            stmt.setString(1, condition);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();

            try (ResultSet resultSet = (ResultSet) stmt.getObject(2)) {
                while (resultSet.next()) {
                    ProductDetailsDTO product = new ProductDetailsDTO();
                    product.setProductCode(getNullableLong(resultSet, "PRODUCT_CODE"));
                    product.setProductCategoryName(getNullableString(resultSet, "PRODUCT_CATEGORY_NAME"));
                    product.setProductName(getNullableString(resultSet, "PRODUCT_NAME"));
                    product.setUnitPrice(getNullableLong(resultSet, "UNIT_PRICE"));
                    product.setLastArrivalDate(resultSet.getDate("LAST_ARRIVAL_DATE")); // Date型はwasNullチェック不要
                    product.setModelNumber(getNullableString(resultSet, "MODEL_NUMBER"));
                    product.setDiscountedPrice(getNullableLong(resultSet, "DISCOUNTED_PRICE"));

                    products.add(product);
                    // デバッグ用の出力
                    System.out.println("Product Code: " + product.getProductCode() + ", Product Name: " + product.getProductName());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return products;
    }
}
