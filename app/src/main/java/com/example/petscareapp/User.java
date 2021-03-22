package com.example.petscareapp;

public class User {
    String name;
    String email;
    String password;
    String city;
    String phone;
    String summary;

    public User(String name, String email, String password, String location, String phone, String summary, int rating) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = location;
        this.phone = phone;
        this.summary = summary;
    }

    public void addName(String name) {
        this.name = name;
    }

    public void changeName(String name){
        this.name = name;
    }

    public void addEmail(String email){
        this.email = email;
    }

    public void changeEmail(String email){
        this.email = email;
    }

    public void addPhoneNumber(String phone){
        this.phone = phone;
    }

    public void changePhoneNumber(String phone){
        this.phone = phone;
    }

    public void addPassword(String password){
        this.password = password;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public void login(String email, String password) {
    }

    public void logout() {
    }

    public void addSummary(String summary){
        this.summary = summary;
    }

    public void editSummary(String summary){
        this.summary = summary;
    }

    public void setLocation(String location){
        this.city = location;
    }

    public void editLocation(String location){
        this.city = location;
    }

}
