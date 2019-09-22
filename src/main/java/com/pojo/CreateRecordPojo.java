package com.pojo;

public class CreateRecordPojo {

    private String country;
    private String name;
    private String position;
    private float risk;
    private float yob;


    // Getter Methods
    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public float getRisk() {
        return risk;
    }

    public float getYob() {
        return yob;
    }

    // Setter Methods
    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRisk(float risk) {
        this.risk = risk;
    }

    public void setYob(float yob) {
        this.yob = yob;
    }

}
