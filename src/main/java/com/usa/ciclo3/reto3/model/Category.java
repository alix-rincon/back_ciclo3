package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Alix Rincón
 */
@Entity
@Table(name = "category")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Computer> computers;

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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Computer> getComputers() {
        return computers;
    }
    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }   
    
}
