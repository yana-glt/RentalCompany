package com.solvd.RentalCompany.core;

import java.time.LocalDate;
import java.util.Objects;

public class ReservationCore {
    private Integer id;
    private Integer clientId;
    private Integer employeeId;
    private Integer carId;
    private Integer insuranceId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Double price;

    public ReservationCore() {
    }

    public ReservationCore(Integer clientId, Integer employeeId, Integer carId, Integer insuranceId, LocalDate fromDate, LocalDate toDate, Double price) {
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.carId = carId;
        this.insuranceId = insuranceId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
    }

    public ReservationCore(Integer id, Integer clientId, Integer employeeId, Integer carId, Integer insuranceId, LocalDate fromDate, LocalDate toDate, Double price) {
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
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
        ReservationCore that = (ReservationCore) o;
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
        return "ReservationCore{" +
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