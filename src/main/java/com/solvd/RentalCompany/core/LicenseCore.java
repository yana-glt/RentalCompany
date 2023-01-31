package com.solvd.RentalCompany.core;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class LicenseCore {
    private Integer id;
    private Integer clientId;
    private String number;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private Boolean isValid;

    public LicenseCore() {
    }

    public LicenseCore(Integer clientId, String number, LocalDate issueDate, LocalDate expiryDate, Boolean isValid) {
        this.clientId = clientId;
        this.number = number;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.isValid = isValid;
    }

    public LicenseCore(Integer id, Integer clientId, String number, LocalDate issueDate, LocalDate expiryDate, Boolean isValid) {
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
        LicenseCore that = (LicenseCore) o;
        return Objects.equals(id, that.id)
                && Objects.equals(clientId, that.clientId)
                && Objects.equals(number, that.number)
                && Objects.equals(issueDate, that.issueDate)
                && Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, number, issueDate, expiryDate);
    }

    @Override
    public String toString() {
        return "LicenseCore{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", number='" + number + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", isValid=" + isValid +
                '}';
    }
}