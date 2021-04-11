package com.example.petscareapp.models;

public class PetService {
    ServiceType serviceType;
    int serviceDuration;
    double servicePrice;
    PetType petType;

    public PetService(ServiceType serviceType, int serviceDuration, double servicePrice, PetType petType) {
        this.serviceType = serviceType;
        this.serviceDuration = serviceDuration;
        this.servicePrice = servicePrice;
        this.petType = petType;
    }


    public void addServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void changeServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void addServiceDuration(int serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public void changeServiceDuration(int serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public void changeServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public void selectTypeOfPet(PetType petType) {
        this.petType = petType;
    }

    public void changeTypeOfPet(PetType petType) {
        this.petType = petType;
    }

}
