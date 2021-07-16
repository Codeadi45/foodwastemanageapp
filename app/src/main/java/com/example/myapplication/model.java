package com.example.myapplication;

public class model {

    private String name;
    private String food;
    private String location, phone;

    model() {
    }

    public model(String name,String food,String location,String phone) {
        this.name = name;
        this.food = food;
        this.location = location;
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


