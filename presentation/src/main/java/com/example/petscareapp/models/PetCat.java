package com.example.petscareapp.models;

public class PetCat extends Pet{

    public PetCat(){
        name = "Cat's name";
        gender = "female";
        age = 0.0;
        petType = PetType.CAT;
        weight = 0.0;
        awards = "no info";
        diseases = "no info";
        isVaccinated = true;
        isAggressive = false;
        info = "no info";
    }

    @Override
    public Pet createPet() {
        return new PetCat();
    }
}
