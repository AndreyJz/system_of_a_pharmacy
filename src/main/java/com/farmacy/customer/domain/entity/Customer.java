package com.farmacy.customer.domain.entity;

public class Customer {
    private String id;
    private int docType;
    private String name;
    private String lastName;
    private int age;
    private String birthdate;
    private String regdate;
    private int idNeighborhood;

    public Customer(){}

    public Customer(String id, int docType, String name, String lastName, int age, String birthdate, String regdate, int idNeighborhood) {
        this.id = id;
        this.docType = docType;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthdate = birthdate;
        this.regdate = regdate;
        this.idNeighborhood = idNeighborhood;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDocType() {
        return docType;
    }

    public void setDocType(int docType) {
        this.docType = docType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getIdNeighborhood() {
        return idNeighborhood;
    }

    public void setIdNeighborhood(int idNeighborhood) {
        this.idNeighborhood = idNeighborhood;
    }

    
    
}
