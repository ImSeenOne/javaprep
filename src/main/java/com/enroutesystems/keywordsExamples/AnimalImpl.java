package com.enroutesystems.keywordsExamples;

public abstract class AnimalImpl implements IAnimal {
    private String species;
    private String regularName;
    private byte generatedByte;

    public String getRegularName() {
        return regularName;
    }

    public void setRegularName(String regularName) {
        this.regularName = regularName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public byte getGeneratedByte() {
        return generatedByte;
    }

    public void setGeneratedByte(byte generatedByte) {
        this.generatedByte = generatedByte;
    }
}

