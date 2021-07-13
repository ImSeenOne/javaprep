package com.enroutesystems;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;


@Slf4j
public class Ant extends Animal{

    protected double legSize;
    private long colonySize;
    private String range;
    private short antennaFolds; //generally 2

    public Ant(float height, float weight, int legs, String regularName, String species, double legSize, long colonySize, String range, short antennaFolds) {
        super(height, weight, legs, regularName, species);
        this.legSize = legSize;
        this.colonySize = colonySize;
        this.range = range;
        this.antennaFolds = antennaFolds;
    }

    public static Logger getLog() {
        return log;
    }

    public double getLegSize() {
        return legSize;
    }

    public void setLegSize(double legSize) {
        this.legSize = legSize;
    }

    public long getColonySize() {
        return colonySize;
    }

    public void setColonySize(long colonySize) {
        this.colonySize = colonySize;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public short getAntennaFolds() {
        return antennaFolds;
    }

    public void setAntennaFolds(short antennaFolds) {
        this.antennaFolds = antennaFolds;
    }

    public enum HibernMonths{
        DECEMBER,
        JANUARY,
        FEBRUARY
    }

    @Override
    public String toString() {
        return "Ant{" +
                "legSize=" + legSize +
                ", colonySize=" + colonySize +
                ", range='" + range + '\'' +
                ", antennaFolds=" + antennaFolds +
                ", heigh=" + super.getHeight() +
                ", weight=" + super.getWeight() +
                ", legs=" + super.getLegs() +
                ", regularName=" + super.getRegularName() +
                ", species=" + super.getSpecies() +
                '}';
    }

    public static void main (String args[]) {
        Ant ant = new Ant(2, 6, 6, "Hormiga", "Formicidae Solenopsis", 0.02, 342234234, "Soldado", Short.parseShort("2"));
        log.info(ant.toString());
        log.info("Listing months where the ant hibernates:");
        for(HibernMonths month : HibernMonths.values()){
            log.info(month.toString());
        }
    }
/**
 * 	synchronized throw throws //native transient volatile
 */

}
