package com.solvd.RentalCompany.models;

import com.solvd.RentalCompany.jaxb.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Objects;
@XmlRootElement(name="technical_inspection")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "technical_inspection", propOrder = {"id", "carId", "date", "organization"})
public class TechnicalInspection {
    @XmlAttribute(required = true)
    private Integer id;
    @XmlElement(name="car_id")
    private Integer carId;
    @XmlJavaTypeAdapter(type=LocalDate.class, value= LocalDateAdapter.class)
    @XmlElement
    private LocalDate date;
    @XmlElement(name="organization")
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