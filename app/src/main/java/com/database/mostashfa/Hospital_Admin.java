package com.database.mostashfa;

public class Hospital_Admin {
    //primary key hospital_id and admin name
    int hospital_id; //foreign key
    String admin_name;
    String password;


    public Hospital_Admin(int hospital_id, String admin_name, String password) {
        this.hospital_id = hospital_id;
        this.admin_name = admin_name;
        this.password = password;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
