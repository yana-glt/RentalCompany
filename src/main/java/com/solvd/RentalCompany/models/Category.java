package com.solvd.RentalCompany.models;

import java.util.Objects;

public class Category {
    private String id;
    private String name;
    private String description;
    private Double coefficient;

    public Category() {
    }

    public Category(String id, String name, String description, Double coefficient) {
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
        Category category = (Category) o;
        return Objects.equals(id, category.id)
                && Objects.equals(name, category.name)
                && Objects.equals(coefficient, category.coefficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coefficient);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }
}
