package com.farmacy.idtype.domain.entity;

public class IdType {
    private int id;
    private String name;
    
    public IdType() {
    }

    public IdType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
