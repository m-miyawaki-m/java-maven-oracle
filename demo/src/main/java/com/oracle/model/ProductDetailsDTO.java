package com.oracle.model;

import java.sql.Date;

public class ProductDetailsDTO {
    private Long productCode; // NUMBER(38) はJavaのLong型に対応
    private String productCategoryName; // VARCHAR2(100) はString型に対応
    private String productName; // VARCHAR2(100) はString型に対応
    private Long unitPrice; // NUMBER(38) はLong型に対応
    private Date lastArrivalDate; // DATE はJavaのDate型に対応
    private String modelNumber; // VARCHAR2(10) はString型に対応
    private Long discountedPrice; // NUMBER(38) はLong型に対応

    // 各フィールドのゲッターとセッター
    // productCode
    public Long getProductCode() {
        return productCode;
    }
    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }
    
    // productCategoryName
    public String getProductCategoryName() {
        return productCategoryName;
    }
    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    // productName
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName= productName;
    }

    // unitPrice
    public Long getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    // lastArrivalDate
    public Date getLastArrivalDate() {
        return lastArrivalDate;
    }
    public void setLastArrivalDate(Date lastArrivalDate) {
        this.lastArrivalDate = lastArrivalDate;
    }

    // modelNumber
    public String getModelNumber() {
        return modelNumber;
    }
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    // discountedPrice
    public Long getDiscountedPrice() {
        return discountedPrice;
    }
    public void setDiscountedPrice(Long discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}