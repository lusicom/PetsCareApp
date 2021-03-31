package com.example.petscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.petscareapp.models.PetBird;
import com.example.petscareapp.models.PetCat;
import com.example.petscareapp.models.PetDog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PetCat cat1 = new PetCat();
        cat1.createPet();

        PetDog dog1 = new PetDog();
        dog1.createPet();

        PetBird bird1 = new PetBird();
        bird1.createPet();
    }
}