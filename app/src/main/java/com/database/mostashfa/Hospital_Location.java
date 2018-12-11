package com.database.mostashfa;

public class Hospital_Location {
    //primary key hospital id, lomgitude and latitude
    int hospital_id;  //foreign key
    String latitude;
    String longitude;


    public Hospital_Location(int hospital_id, String latitude, String longitude) {
        this.hospital_id = hospital_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
