package com.solvd.RentalCompany.models;

import com.solvd.RentalCompany.jaxb.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Objects;
@XmlRootElement(name="car_service")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "car_service", propOrder = {"id", "carId", "serviceId", "price", "date"})
public class CarService {
    @XmlAttribute(required = true)
    private Integer id;
    @XmlElement(name="car_id")
    private Integer carId;
    @XmlElement(name="service_id")
    private Integer serviceId;
    @XmlElement(name="price")
    private Double price;
    @XmlJavaTypeAdapter(type=LocalDate.class, value=LocalDateAdapter.class)
    @XmlElement
    private LocalDate date;

    public CarService() {
    }

    public CarService(Integer id, Integer carId, Integer serviceId, Double price, LocalDate date) {
        this.id = id;
        this.carId = carId;
        this.serviceId = serviceId;
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

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarService that = (CarService) o;
        return Objects.equals(id, that.id)
                && Objects.equals(carId, that.carId)
                && Objects.equals(serviceId, that.serviceId)
                && Objects.equals(price, that.price)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carId, serviceId, price, date);
    }

    @Override
    public String toString() {
        return "CarService{" +
                "id=" + id +
                ", carId=" + carId +
                ", serviceId=" + serviceId +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}