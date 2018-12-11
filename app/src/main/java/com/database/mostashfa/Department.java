package com.database.mostashfa;

public class Department {
    //primary: hospital_id and name
    int hospital_id; //foreign key
    String name;
    int bed_count;
    int cost_per_night;

    public Department(int hospital_id, String name, int bed_count, int cost_per_night) {
        this.hospital_id = hospital_id;
        this.name = name;
        this.bed_count = bed_count;
        this.cost_per_night = cost_per_night;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBed_count() {
        return bed_count;
    }

    public void setBed_count(int bed_count) {
        this.bed_count = bed_count;
    }

    public int getCost_per_night() {
        return cost_per_night;
    }

    public void setCost_per_night(int cost_per_night) {
        this.cost_per_night = cost_per_night;
    }
}
