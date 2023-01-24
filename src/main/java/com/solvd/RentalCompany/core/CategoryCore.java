package com.solvd.RentalCompany.core;

import java.util.Objects;

public class CategoryCore {
    private String id;
    private String name;
    private String description;
    private Double coefficient;

    public CategoryCore() {
    }

    public CategoryCore(String name, String description, Double coefficient) {
        this.name = name;
        this.description = description;
        this.coefficient = coefficient;
    }

    public CategoryCore(String id, String name, String description, Double coefficient) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.coefficient = coefficient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryCore that = (CategoryCore) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(coefficient, that.coefficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coefficient);
    }

    @Override
    public String toString() {
        return "CategoryCore{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }
}