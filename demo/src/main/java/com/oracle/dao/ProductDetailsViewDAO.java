package com.oracle.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oracle.model.ProductDetailsDTO;

public class ProductDetailsViewDAO {
    public List<ProductDetailsDTO> getProductDetailsDTOs() throws SQLException {
        List<ProductDetailsDTO> products = new ArrayList<>();
        
        try (Connection connection = DBConnectorOracle.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM product_details_view")) {
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
}
