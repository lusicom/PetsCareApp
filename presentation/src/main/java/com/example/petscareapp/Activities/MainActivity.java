package com.example.petscareapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.petscareapp.R;
import com.example.petscareapp.TypeWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TypeWriter typeWriter = (TypeWriter) findViewById(R.id.textChooseUserType);
        typeWriter.setText("");
        typeWriter.setCharacterDelay(150);
        typeWriter.animateText("Please, choose the user type");
    }

    public void onClickPetOwner(View view) {
        Intent intentPetOwnerLogin = new Intent(this, PetOwnerLoginActivity.class);
        startActivity(intentPetOwnerLogin);
    }

    public void onClickSpecialist(View view) {
        Intent intentSpecialistLogin = new Intent(this, SpecialistLoginActivity.class);
        startActivity(intentSpecialistLogin);
    }
}