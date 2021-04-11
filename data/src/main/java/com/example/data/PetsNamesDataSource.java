package com.example.data;

import java.util.ArrayList;

public class PetsNamesDataSource {

    ArrayList<String> petsNames = new ArrayList<>();

    public PetsNamesDataSource(){
        this.petsNames.add("Bob");
        this.petsNames.add("Bim");
        this.petsNames.add("Ted");
        this.petsNames.add("Mike");
        this.petsNames.add("Kim");
        this.petsNames.add("Robby");
        this.petsNames.add("Billy");
        this.petsNames.add("Lucky");
        this.petsNames.add("Tracy");
        this.petsNames.add("Shelby");
    }

    public ArrayList<String> getPetsNames() {
        return petsNames;
    }

}




