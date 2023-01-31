package com.solvd.RentalCompany.core;

import java.time.LocalDate;
import java.util.Objects;

public class TechnicalInspectionCore {
    private Integer id;
    private Integer carId;
    private LocalDate date;
    private String organization;

    public TechnicalInspectionCore() {
    }

    public TechnicalInspectionCore(Integer carId, LocalDate date, String organization) {
        this.carId = carId;
        this.date = date;
        this.organization = organization;
    }

    public TechnicalInspectionCore(Integer id, Integer carId, LocalDate date, String organization) {
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
        TechnicalInspectionCore that = (TechnicalInspectionCore) o;
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
        return "TechnicalInspectionCore{" +
                "id=" + id +
                ", carId=" + carId +
                ", date=" + date +
                ", organization='" + organization + '\'' +
                '}';
    }
}