package com.example.petscareapp.models;

public class PetDog extends Pet{

    public PetDog() {
        name = "Dog's name";
        gender = "male";
        age = 0.0;
        petType = PetType.DOG;
        weight = 0.0;
        awards = "no info";
        diseases = "no info";
        isVaccinated = true;
        isAggressive = false;
        info = "no info";
    }

    @Override
    public Pet createPet() {
        return new PetDog();
    }
}
