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
    private String learningPathRecommendation;

    public Integration() {
    }

    public Integration(String name, String techStack, String learningPathRecommendation) {
        this.name = name;
        this.techStack = techStack;
        this.learningPathRecommendation = learningPathRecommendation;
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

    public String getLearningPathRecommendation() {
        return learningPathRecommendation;
    }

    public void setLearningPathRecommendation(String learningPathRecommendation) {
        this.learningPathRecommendation = learningPathRecommendation;
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
                ", learningPathRecommendation='" + learningPathRecommendation + '\'' +
                '}';
    }
}
