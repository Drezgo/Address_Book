package com.example.lab_3;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty PIP = new SimpleStringProperty("");
    private SimpleStringProperty PHONE = new SimpleStringProperty("");

    public Person(String pip, String phone) {
        this.PIP = new SimpleStringProperty(pip);
        this.PHONE = new SimpleStringProperty(phone);
    }

    public Person() {
    }

    public String getPIP() {
        return PIP.get();
    }

    public SimpleStringProperty pipProperty() {
        return PIP;
    }

    public void setPIP(String pip) {
        this.PIP.set(pip);
    }

    public String getPHONE() {
        return PHONE.get();
    }

    public SimpleStringProperty phoneProperty() {
        return PHONE;
    }

    public void setPHONE(String phone) {
        this.PHONE.set(phone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "pip=" + PIP +
                ", phone=" + PHONE +
                '}';
    }

}
