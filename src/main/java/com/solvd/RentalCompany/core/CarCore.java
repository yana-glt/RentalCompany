package com.solvd.RentalCompany.core;

import java.time.Year;
import java.util.Objects;

public class CarCore {
    private Integer id;
    private String vin;
    private String categoryId;
    private String brand;
    private String model;
    private String number;
    private Year year;
    private Double dayPrice;

    public CarCore() {
    }

    public CarCore(String vin, String categoryId, String brand, String model, String number, Year year, Double dayPrice) {
        this.vin = vin;
        this.categoryId = categoryId;
        this.brand = brand;
        this.model = model;
        this.number = number;
        this.year = year;
        this.dayPrice = dayPrice;
    }

    public CarCore(Integer id, String vin, String categoryId, String brand, String model, String number, Year year, Double dayPrice) {
        this.id = id;
        this.vin = vin;
        this.categoryId = categoryId;
        this.brand = brand;
        this.model = model;
        this.number = number;
        this.year = year;
        this.dayPrice = dayPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(Double dayPrice) {
        this.dayPrice = dayPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarCore carCore = (CarCore) o;
        return Objects.equals(id, carCore.id)
                && Objects.equals(vin, carCore.vin)
                && Objects.equals(categoryId, carCore.categoryId)
                && Objects.equals(brand, carCore.brand)
                && Objects.equals(model, carCore.model)
                && Objects.equals(year, carCore.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, categoryId, brand, model, year);
    }

    @Override
    public String toString() {
        return "CarCore{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", dayPrice=" + dayPrice +
                '}';
    }
}