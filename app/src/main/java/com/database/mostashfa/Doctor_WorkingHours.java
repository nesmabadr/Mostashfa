package com.database.mostashfa;

public class Doctor_WorkingHours {
    //primary key doctor_id and working hours
    int doctor_id;   //foreign key
    String working_hours;


    public Doctor_WorkingHours(int doctor_id, String working_hours) {
        this.doctor_id = doctor_id;
        this.working_hours = working_hours;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(String working_hours) {
        this.working_hours = working_hours;
    }
}
