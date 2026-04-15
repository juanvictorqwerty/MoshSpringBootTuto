package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SoftareEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String techstack;

    public SoftareEngineer() {
    }

    public SoftareEngineer(Integer id, String name, String techstack) {
        this.id = id;
        this.name = name;
        this.techstack = techstack;
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

    public String getTechstack() {
        return techstack;
    }

    public void setTechstack(String techstack) {
        this.techstack = techstack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SoftareEngineer that = (SoftareEngineer) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(techstack, that.techstack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, techstack);
    }

    @Override
    public String toString() {
        return "SoftareEngineer [id=" + id + ", name=" + name + ", techstack=" + techstack + "]";
    }
}
