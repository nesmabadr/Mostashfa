package com.database.mostashfa;

public class Operation {
    int id; //primary key
    String department_name; //foreign key
    int cost;
    String name;


    public Operation(int id, String department_name, int cost, String name) {
        this.id = id;
        this.department_name = department_name;
        this.cost = cost;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
