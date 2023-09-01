package com.maliha.springjdbcrestapi.model;

public class PetStore {
    private String name;
    private int id;
    private int availability;
    private String type;

    public PetStore(String name, int id, int availability,String type) {
        this.name = name;
        this.id = id;
        this.availability = availability;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAvailability() {
        return availability;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
