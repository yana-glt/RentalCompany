package com.solvd.RentalCompany.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.RentalCompany.jaxb.YearAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Year;
import java.util.Objects;
@XmlRootElement(name="car")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "car", propOrder = {"id", "vin", "categoryId", "brand", "model", "number", "year", "dayPrice"})
//@JsonRootName("car")
public class Car {
    @XmlAttribute(required = true)
    @JsonProperty("id")
    private Integer id;
    @XmlElement(name="vin")
    @JsonProperty("vin")
    private String vin;
    @XmlElement(name="category-id")
    @JsonProperty("category_id")
    private String categoryId;
    @XmlElement(name="brand")
    @JsonProperty("brand")
    private String brand;
    @XmlElement(name="model")
    @JsonProperty("model")
    private String model;
    @XmlElement(name="number")
    @JsonProperty("number")
    private String number;
    @XmlJavaTypeAdapter(type=Year.class, value= YearAdapter.class)
    @XmlElement(name="year")
    @JsonProperty("year")
    private Year year;
    @XmlElement(name="dayPrice")
    @JsonProperty("day_price")
    private Double dayPrice;

    public Car() {
    }

    public Car(Integer id, String vin, String categoryId, String brand, String model, String number, Year year, Double dayPrice) {
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