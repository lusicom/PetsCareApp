package com.example.petscareapp.models;

abstract class Pet {

    String name;
    String gender;
    double age;
    PetType petType;
    double weight;
    String awards;
    String diseases;
    boolean isVaccinated;
    boolean isAggressive;
    String info;

   public abstract Pet createPet();


    public void changePetName(String name) {
        this.name = name;
    }

    public void changePetGender(String gender) {
        this.gender = gender;
    }

    public void changePetAge(int age) {
        this.age = age;
    }

    public void changeTypeOfPet(PetType petType) {
        this.petType = petType;
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

    public void changeInfoAboutPet(String info) {
        this.info = info;
    }

}
