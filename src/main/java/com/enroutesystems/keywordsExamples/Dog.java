package com.enroutesystems.keywordsExamples;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Dog extends Animal {
    private String plateNumber;
    private String name;

    public Dog(String plateNumber, String name, float height, float weight, int legs, String regularName, String species) {
        super(height, weight, legs, regularName, species);
        this.name = name;
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Dog object: [name: "+ this.getName()+", plateNumber: "+ this.getPlateNumber()+", height: "+ this.getHeight()+", weight: "+ this.getWeight()+", legs: "+ this.getLegs()+", regularName: "+ this.getRegularName()+", species: "+ this.getSpecies()+"]";
    }

    public static void main (String args[]){
        Dog firulais = new Dog("SFT123", "Firulais", 50, 25,4,"Perro", "Canis familiaris Linnaeus");

        assert firulais instanceof Dog: String.format(firulais.getName() + " is NOT an instance of a Dog()");

        log.info("Firulais info: " + firulais.toString());

        ArrayList<Dog> dogs = new ArrayList<>();
        int i = 0;
        /**
         * I know I cod use an iterator, but I decided to use this way in order to use the keywords
         */
        do {
            i++;
            if(i == 3) {
                log.info("Ayye, I hate the number three, let's not create the 3rd dog.");
                continue;
            }
            dogs.add(new Dog("GND-" + i, "Dog" + i, 50, 25,4,"Perro", "Canis familiaris Linnaeus"));

            log.info("\'i\' value: "+i);
        } while(dogs.size() < 5);

        log.info(dogs.toString());
    }



}
