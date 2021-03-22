package com.example.petscareapp;

public class PetOwner extends User{

    String address;
    Pet myPet;
    String serviceRequest;
    String feedback;
    int rate;

    public PetOwner(String name, String email, String password, String location, String phone,
                    String summary, int rating, String address, Pet myPet, String serviceRequest,
                    String feedback) {
        super(name, email, password, location, phone, summary, rating);
        this.address = address;
        this.myPet = myPet;
        this.serviceRequest = serviceRequest;
        this.feedback = feedback;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void changAddress(String address){
        this.address = address;
    }

    public void addPet(Pet myPet){
        this.myPet = myPet;
    }

    public void deletePet(Pet myPet){
        this.myPet = myPet;
    }

    public void addServiceRequest(String serviceRequest){
        this.serviceRequest = serviceRequest;
    }

    public void deleteServiceRequest(String serviceRequest){
        this.serviceRequest = serviceRequest;
    }

    public void markServiceAsDone(String serviceRequest){
        this.serviceRequest = serviceRequest;
    }

    public void rateSpecialist(int rate){
        this.rate = rate;
    }
}
