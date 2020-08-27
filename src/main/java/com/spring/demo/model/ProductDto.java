package com.spring.demo.model;

import java.util.Date;
import java.util.Objects;

public class ProductDto {

    private String productName;
    private String productType;
    private int productWeight;

    private Date productDate;

    public ProductDto() {
    }

    public ProductDto(String productName, String productType, int productWeight) {
        this.productName = productName;
        this.productType = productType;
        this.productWeight = productWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return productWeight == that.productWeight &&
                productName.equals(that.productName) &&
                productType.equals(that.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productType, productWeight);
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }
}
