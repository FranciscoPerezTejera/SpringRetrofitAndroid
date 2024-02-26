package com.example.springretrofit.model;

public class Model {

    public Integer id;
    public Integer code;
    public String model;
    public String imageModel;
    public Car car;

    public Model(String model, String imageModel) {
        this.model = model;
        this.imageModel = imageModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageModel() {
        return imageModel;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setImageModel(String imageModel) {
        this.imageModel = imageModel;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", code=" + code +
                ", model='" + model + '\'' +
                ", imageModel='" + imageModel + '\'' +
                ", car=" + car +
                '}';
    }
}
