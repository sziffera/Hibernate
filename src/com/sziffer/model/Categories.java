package com.sziffer.model;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Categories {
    @Id
    @GeneratedValue
    private int categoryId;
    private String name;
    @Column(name = "longname")
    private String description;

    public Categories() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public void setDescription(String longname) {
        this.description = longname;
    }
}
