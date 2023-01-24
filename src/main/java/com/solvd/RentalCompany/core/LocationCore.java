package com.solvd.RentalCompany.core;

import java.util.Objects;

public class LocationCore {
    private Integer id;
    private String name;
    private String phone;
    private String address;
    private String country;

    public LocationCore() {
    }

    public LocationCore(String name, String phone, String address, String country) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.country = country;
    }

    public LocationCore(Integer id, String name, String phone, String address, String country) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        LocationCore that = (LocationCore) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(address, that.address)
                && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, country);
    }

    @Override
    public String toString() {
        return "LocationCore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}