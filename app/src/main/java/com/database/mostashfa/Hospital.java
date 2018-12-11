package com.database.mostashfa;

public class Hospital {
    int id; //primary key
    String name;
    int incubator_count;
    int icu_count;
    String sector;


    public Hospital(int id, String name, int incubator_count, int icu_count, String sector) {
        this.id = id;
        this.name = name;
        this.incubator_count = incubator_count;
        this.icu_count = icu_count;
        this.sector = sector;
    }

    public Hospital() {
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

    public int getIncubator_count() {
        return incubator_count;
    }

    public void setIncubator_count(int incubator_count) {
        this.incubator_count = incubator_count;
    }

    public int getIcu_count() {
        return icu_count;
    }

    public void setIcu_count(int icu_count) {
        this.icu_count = icu_count;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
