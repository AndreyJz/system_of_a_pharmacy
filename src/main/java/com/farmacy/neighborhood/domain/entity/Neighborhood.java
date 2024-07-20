package com.farmacy.neighborhood.domain.entity;

public class Neighborhood {
    private int id;
    private String neighborhood;
    private int IdCity;
    public Neighborhood() {
    }
    public Neighborhood(int id, String neighborhood, int idCity) {
        this.id = id;
        this.neighborhood = neighborhood;
        this.IdCity = idCity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return neighborhood;
    }
    public void setName(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public int getIdCity() {
        return IdCity;
    }
    public void setIdCity(int idCity) {
        this.IdCity = idCity;
    }

    
}
