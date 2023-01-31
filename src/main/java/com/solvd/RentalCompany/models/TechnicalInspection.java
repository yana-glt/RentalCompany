package com.solvd.RentalCompany.models;

import java.time.LocalDate;
import java.util.Objects;

public class TechnicalInspection {
    private Integer id;
    private Integer carId;
    private LocalDate date;
    private String organization;

    public TechnicalInspection() {
    }

    public TechnicalInspection(Integer id, Integer carId, LocalDate date, String organization) {
        this.id = id;
        this.carId = carId;
        this.date = date;
        this.organization = organization;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnicalInspection that = (TechnicalInspection) o;
        return Objects.equals(id, that.id)
                && Objects.equals(carId, that.carId)
                && Objects.equals(date, that.date)
                && Objects.equals(organization, that.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carId, date, organization);
    }

    @Override
    public String toString() {
        return "TechnicalInspection{" +
                "id=" + id +
                ", carId=" + carId +
                ", date=" + date +
                ", organization='" + organization + '\'' +
                '}';
    }
}