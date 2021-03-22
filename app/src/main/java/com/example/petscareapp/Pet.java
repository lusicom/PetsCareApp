package com.example.petscareapp;

public class Pet {

    String name;
    String gender;
    double age;
    PetType petType;
    double weight;
    String photo;
    String awards;
    String diseases;
    boolean isVaccinated;
    boolean isAggressive;
    String info;

    public Pet(String name, String gender, double age, PetType petType, double weight,
               String photo, String awards, String diseases, boolean vaccinated, boolean aggressive,
               String info) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.petType = petType;
        this.weight = weight;
        this.photo = photo;
        this.awards = awards;
        this.diseases = diseases;
        this.isVaccinated = vaccinated;
        this.isAggressive = aggressive;
        this.info = info;
    }


    public void setPetName(String name) {
        this.name = name;
    }

    public void changePetName(String name) {
        this.name = name;
    }

    public void setPetGender(String gender) {
        this.gender = gender;
    }

    public void changePetGender(String gender) {
        this.gender = gender;
    }

    public void setPetAge(int age) {
        this.age = age;
    }

    public void changePetAge(int age) {
        this.age = age;
    }

    public void selectTypeOfPet(PetType petType) {
        this.petType = petType;
    }

    public void changeTypeOfPet(PetType petType) {
        this.petType = petType;
    }

    public void setPetWeight(double weight) {
        this.weight = weight;
    }

    public void changePetWeight(double weight) {
        this.weight = weight;
    }

    public void addPetAwards(String awards) {
        this.awards = awards;
    }

    public void deletePetAward(String awards) {
        this.awards = awards;
    }

    public void addDisease(String diseases) {
        this.diseases = diseases;
    }

    public void deleteDisease(String diseases) {
        this.diseases = diseases;
    }

    public void isVaccinated(boolean vaccinated) {
        this.isVaccinated = vaccinated;
    }

    public void isAggressive(boolean aggressive) {
        this.isAggressive = aggressive;
    }

    public void addInfoAboutPet(String info) {
        this.info = info;
    }

    public void changeInfoAboutPet(String info) {
        this.info = info;
    }

}
