package com.example.pedro.carcollection.models;

import com.orm.SugarRecord;

/**
 * Created by Pedro on 30-05-2017.
 */

public class Car extends SugarRecord {
    private String brand, model, body;
    private int year;
    private boolean abs;

    public Car(){
    }

    public Car(String brand, String model, String body, int year, boolean abs) {
        this.brand = brand;
        this.model = model;
        this.body = body;
        this.year = year;
        this.abs = abs;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBody() {
        return body;
    }

    public int getBodyPos(){
        switch (body){
            case "SUV":
                return 0;
            case "HB":
                return 1;
            case "SEDAN":
                return 2;
            case "COUPE":
                return 3;
            case "PICKUP":
                return 4;
            default:
                return 0;
        }
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getYear() {
        return year;
    }

    public int getYearPos(){
        int pos = year;
        pos -= 2010;

        if (pos < 0 || pos > 7){
            return 0;
        }
        else {
            return pos;
        }
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAbs() {
        return abs;
    }

    public void setAbs(boolean abs) {
        this.abs = abs;
    }
}
