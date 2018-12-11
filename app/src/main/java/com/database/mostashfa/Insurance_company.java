package com.database.mostashfa;

public class Insurance_company {
    //primary key: company_name and hospital_id
    int hospital_id; //foreign key
    String company_name;


    public Insurance_company(int hospital_id, String company_name) {
        this.hospital_id = hospital_id;
        this.company_name = company_name;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
