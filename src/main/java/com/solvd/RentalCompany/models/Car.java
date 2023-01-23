package com.solvd.RentalCompany.models;

import java.util.Objects;

public class Car {
    private Integer id;
    private String vin;
    private String categoryId;
    private String brand;
    private String model;
    private String number;
    private String year;
    private Double dayPrice;

    public Car() {
    }

    public Car(Integer id, String vin, String categoryId, String brand, String model, String number, String year, Double dayPrice) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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
        Car car = (Car) o;
        return Objects.equals(id, car.id)
                && Objects.equals(vin, car.vin)
                && Objects.equals(categoryId, car.categoryId)
                && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model)
                && Objects.equals(year, car.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, categoryId, brand, model, year);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", year='" + year + '\'' +
                ", dayPrice=" + dayPrice +
                '}';
    }
}