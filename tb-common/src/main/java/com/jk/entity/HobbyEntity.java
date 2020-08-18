package com.jk.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class HobbyEntity implements Serializable {

    private Integer id;

    private String name;

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

    @Override
    public String toString() {
        return "HobbyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
