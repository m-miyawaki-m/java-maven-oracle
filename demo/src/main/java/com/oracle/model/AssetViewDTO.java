package com.oracle.model;
import lombok.Data;
import java.util.Date;

@Data
public class AssetViewDTO {
    private String assetClassification;
    private Date acquisitionDate;
    private Float acquisitionCost;
}
