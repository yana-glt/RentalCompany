package com.solvd.RentalCompany.models;

import java.util.Objects;

public class Service {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String country;

    public Service() {
    }

    public Service(Integer id, String name, String address, String phone, String country) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id)
                && Objects.equals(name, service.name)
                && Objects.equals(address, service.address)
                && Objects.equals(country, service.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, country);
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}