package com.database.mostashfa;

public class Doctor {
    String department_name;   //foreign key
    int id; //primary
    String name;


    public Doctor(String department_name, int id, String name) {
        this.department_name = department_name;
        this.id = id;
        this.name = name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
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


