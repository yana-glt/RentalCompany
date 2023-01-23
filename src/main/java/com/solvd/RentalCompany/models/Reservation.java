package com.solvd.RentalCompany.models;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    private Integer id;
    private Integer clientId;
    private Integer employeeId;
    private Integer carId;
    private Integer insuranceId;
    private Date fromDate;
    private Date toDate;
    private Double price;

    public Reservation() {
    }

    public Reservation(Integer id, Integer clientId, Integer employeeId, Integer carId, Integer insuranceId, Date fromDate, Date toDate, Double price) {
        this.id = id;
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.carId = carId;
        this.insuranceId = insuranceId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id)
                && Objects.equals(clientId, that.clientId)
                && Objects.equals(employeeId, that.employeeId)
                && Objects.equals(carId, that.carId)
                && Objects.equals(insuranceId, that.insuranceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, employeeId, carId, insuranceId);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", employeeId=" + employeeId +
                ", carId=" + carId +
                ", insuranceId=" + insuranceId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", price=" + price +
                '}';
    }
}
