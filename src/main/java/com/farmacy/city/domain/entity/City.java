package com.farmacy.city.domain.entity;

public class City {
    private int id;
    private String name;
    private int idCountry;
    public City() {
    }
    public City(int id, String city, int idCountry) {
        this.id = id;
        this.name = city;
        this.idCountry = idCountry;
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
    public int getIdCountry() {
        return idCountry;
    }
    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    
}
