package com.enroutesystems;

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
        return "Dog object: [\nname: "+ this.getName()+", \nplateNumber: "+ this.getPlateNumber()+", \nheight: "+ this.getHeight()+", \nweight: "+ this.getWeight()+", \nlegs: "+ this.getLegs()+", \nregularName: "+ this.getRegularName()+", \nspecies: "+ this.getSpecies()+"]";
    }

    public static void main (String args[]){
        Dog firulais = new Dog("SFT123", "Firulais", 50, 25,4,"Perro", "Canis familiaris Linnaeus");

        System.out.println(firulais.toString());
    }

    /**
     * 	assert	break	case
     * 	continue	default
     * double	do	else	enum
     * 	instanceof		long
     * native	new	null	private	protected
     * short	strictfp
     * 	synchronized		throw	throws	transient
     * 			volatile	while
     */

}
