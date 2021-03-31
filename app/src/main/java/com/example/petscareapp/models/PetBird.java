package com.example.petscareapp.models;

public class PetBird extends Pet{

    public PetBird(){
        name = "Bird's name";
        gender = "female";
        age = 0.0;
        petType = PetType.BIRD;
        weight = 0.0;
        awards = "no info";
        diseases = "no info";
        isVaccinated = false;
        isAggressive = false;
        info = "no info";
    }

    @Override
    public Pet createPet() {
        return new PetBird();
    }
}
