package com.example.springretrofit.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Car {

    public Integer id;
    public Integer code;
    public String brand;
    public ArrayList<Model> models;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(ArrayList<Model> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "Car{" +
                "code=" + code +
                ", brand='" + brand + '\'' +
                ", models=" + models +
                '}';
    }
}

