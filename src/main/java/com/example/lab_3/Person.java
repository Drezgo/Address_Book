package com.example.lab_3;

public class Person {
    private String PIP;
    private String PHONE;

    public Person(String PIP,String PHONE ) {
        this.PHONE = PHONE;
        this.PIP = PIP;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getPIP() {
        return PIP;
    }

    public void setPIP(String PIP) {
        this.PIP = PIP;
    }
}
