package com.solvd.RentalCompany.models;

import java.util.Date;
import java.util.Objects;

public class CarService {
    private Integer id;
    private Integer carId;
    private Integer serviceCompanyId;
    private Double price;
    private Date date;

    public CarService() {
    }

    public CarService(Integer id, Integer carId, Integer serviceCompanyId, Double price, Date date) {
        this.id = id;
        this.carId = carId;
        this.serviceCompanyId = serviceCompanyId;
        this.price = price;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getServiceCompanyId() {
        return serviceCompanyId;
    }

    public void setServiceCompanyId(Integer serviceCompanyId) {
        this.serviceCompanyId = serviceCompanyId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarService that = (CarService) o;
        return Objects.equals(id, that.id)
                && Objects.equals(carId, that.carId)
                && Objects.equals(serviceCompanyId, that.serviceCompanyId)
                && Objects.equals(price, that.price)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carId, serviceCompanyId, price, date);
    }

    @Override
    public String toString() {
        return "CarService{" +
                "id=" + id +
                ", carId=" + carId +
                ", serviceCompanyId=" + serviceCompanyId +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
