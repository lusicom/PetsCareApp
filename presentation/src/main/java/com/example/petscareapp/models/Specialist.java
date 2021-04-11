package com.example.petscareapp.models;

public class Specialist extends User {
    String certification;
    int yearsOfExperience;
    double pricePerHour;
    ServiceType serviceType;
    String serviceRequest;
    String serviceDescription;
    String comment;
    int rate;

    public Specialist(String name, String email, String password, String location, String phone,
                      String summary, int rating, String certification, int yearsOfExperience,
                      double pricePerHour, ServiceType serviceType, String serviceRequest,
                      String serviceDescription, String comment, int rate) {
        super(name, email, password, location, phone, summary, rating);
        this.certification = certification;
        this.yearsOfExperience = yearsOfExperience;
        this.pricePerHour = pricePerHour;
        this.serviceType = serviceType;
        this.serviceRequest = serviceRequest;
        this.serviceDescription = serviceDescription;
        this.comment = comment;
        this.rate = rate;
    }


    public void addCertification(String certification){
        this.certification = certification;
    }

    public void deleteCertification(String certification){
        this.certification = certification;
    }

    public void addTypeOfService(ServiceType serviceType){
        this.serviceType = serviceType;
    }

    public void deleteTypeOfService(ServiceType serviceType){
        this.serviceType = serviceType;
    }

    public void setPricePerHour(double pricePerHour){
        this.pricePerHour = pricePerHour;
    }

    public void changePricePerHour(double pricePerHour){
        this.pricePerHour = pricePerHour;
    }

    public void acceptServiceRequest(String serviceRequest){
    this.serviceRequest = serviceRequest;
    }

    public void declineServiceRequest(String serviceRequest){
    this.serviceRequest = serviceRequest;
    }

    public void markServiceRequestAsDone(String serviceRequest){
    this.serviceRequest = serviceRequest;
    }

    public void leaveComment(String comment){
    this.comment = comment;
    }

    public void rateOwner(int rate){
        this.rate = rate;
    }
}
