package com.example.integration.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Integration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String techStack;

    @Column(columnDefinition = "TEXT")
    private String techStackRecommended;

    public Integration() {
    }

    public Integration(String name, String techStack, String techStackRecommended) {
        this.name = name;
        this.techStack = techStack;
        this.techStackRecommended = techStackRecommended;
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

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getTechStackRecommended() {
        return techStackRecommended;
    }

    public void setTechStackRecommended(String techStackRecommended) {
        this.techStackRecommended = techStackRecommended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Integration)) return false;
        Integration that = (Integration) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Integration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", techStack='" + techStack + '\'' +
                ", techStackRecommended='" + techStackRecommended + '\'' +
                '}';
    }
}
