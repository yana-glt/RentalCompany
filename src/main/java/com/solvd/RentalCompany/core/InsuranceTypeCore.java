package com.solvd.RentalCompany.core;

import java.util.Objects;

public class InsuranceTypeCore {
    private Integer id;
    private String categoryId;
    private Double mandatoryPrice;
    private Double additionalPrice;

    public InsuranceTypeCore() {
    }

    public InsuranceTypeCore(String categoryId, Double mandatoryPrice, Double additionalPrice) {
        this.categoryId = categoryId;
        this.mandatoryPrice = mandatoryPrice;
        this.additionalPrice = additionalPrice;
    }

    public InsuranceTypeCore(Integer id, String categoryId, Double mandatoryPrice, Double additionalPrice) {
        this.id = id;
        this.categoryId = categoryId;
        this.mandatoryPrice = mandatoryPrice;
        this.additionalPrice = additionalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Double getMandatoryPrice() {
        return mandatoryPrice;
    }

    public void setMandatoryPrice(Double mandatoryPrice) {
        this.mandatoryPrice = mandatoryPrice;
    }

    public Double getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(Double additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceTypeCore that = (InsuranceTypeCore) o;
        return Objects.equals(id, that.id)
                && Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId);
    }

    @Override
    public String toString() {
        return "InsuranceTypeCore{" +
                "id=" + id +
                ", categoryId='" + categoryId + '\'' +
                ", mandatoryPrice=" + mandatoryPrice +
                ", additionalPrice=" + additionalPrice +
                '}';
    }
}