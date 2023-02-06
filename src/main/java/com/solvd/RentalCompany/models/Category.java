package com.solvd.RentalCompany.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "category", propOrder = {"id", "name", "description", "coefficient"})
public class Category {
    @XmlAttribute(required = true)
    @JsonProperty("id")
    private String id;
    @XmlElement(name="name")
    @JsonProperty("name")
    private String name;
    @XmlElement(name="description")
    @JsonProperty("description")
    private String description;
    @XmlElement(name="coefficient")
    @JsonProperty("coefficient")
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