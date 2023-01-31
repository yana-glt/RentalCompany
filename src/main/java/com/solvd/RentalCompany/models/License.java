package com.solvd.RentalCompany.models;

import java.time.LocalDate;
import java.util.Objects;

public class License {
    private Integer id;
    private Integer clientId;
    private String number;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    private Boolean isValid;

    public License() {
    }

    public License(Integer id, Integer clientId, String number, LocalDate issueDate, LocalDate expiryDate, Boolean isValid) {
        this.id = id;
        this.clientId = clientId;
        this.number = number;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.isValid = isValid;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License license = (License) o;
        return Objects.equals(id, license.id)
                && Objects.equals(clientId, license.clientId)
                && Objects.equals(number, license.number)
                && Objects.equals(issueDate, license.issueDate)
                && Objects.equals(expiryDate, license.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, number, issueDate, expiryDate);
    }

    @Override
    public String toString() {
        return "License{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", number='" + number + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", isValid=" + isValid +
                '}';
    }
}