package com.enroutesystems.keywordsExamples;



public class Animal extends AnimalImpl{
    private boolean isAlive;
    private float height;
    private double weight;
    private int legs;

    public Animal(float height, float weight, int legs, String regularName, String species) {
            this.isAlive = true;
            this.height = height;
            this.weight = weight;
            this.legs = legs;
            this.setRegularName(regularName);
            this.setSpecies(species);
            this.setGeneratedByte(super.generateByte());
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public String eat(boolean isEating) {
        char result = (isEating) ? 't' : 'f';
        switch(result) {
            case 't':
                return "This animal is eating";
            case 'f':
                return "This animal is not eating";
        }
        return "";
    }

    @Override
    public String breathe(boolean isBreathing) {
        if(isBreathing) {
            return "This animal is breathing";
        } else {
            this.setAlive(false);
            return "The animal is not breathing, its status is now set to not alive.";
        }
    }

    @Override
    public void kill() {

    }
}
