package com.enroutesystems.collectionExamples;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class CollectionsExample {

    public synchronized void print(int n){
        for(int i=1;i<=5;i++){
            log.info(Integer.toString(n*i));
            try{
                Thread.sleep(400);
            }catch(Exception e){log.error(e.toString());}
        }

    }

    public synchronized void isEven(int n) {
        String word = (n % 2 == 0) ? "" : "not ";
        log.info("The number " + n + " is " + word + "even");
    }

    public synchronized void higherThan100(int n) {
        String word = (n > 100) ? "" : "not ";
        log.info("The number " + n + " is " + word + "greater than 100");
    }
}

class Thread1 extends Thread{
    CollectionsExample ce;
    Thread1(CollectionsExample ce){
        this.ce=ce;
    }
    public void run(){
        ce.print(5);
        ce.isEven(50);
        ce.higherThan100(150);
    }

}

class Thread2 extends Thread{
    CollectionsExample ce;
    Thread2(CollectionsExample ce){
        this.ce=ce;
    }
    public void run(){
        ce.print(100);
        ce.isEven(31);
        ce.higherThan100(96);
    }
}

@Slf4j
class TestExample {
    public static void main (String args[]) {

        /**
         * java.util.Collections.unmodifiablelList() Example
         */
        log.info("Testing \'.unmodifiableList()\':");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Sanda", "MuayThai", "KickBoxing", "JiuJitsu");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        log.info("\tUnmodifiable List: " + unmodifiableList);
        log.info("\tAdding element to an already created unmodifable list...");
        list.add("Box");
        log.info("\tPrinting unmodifiable list after trying to add new element: " + unmodifiableList);

        log.info("\n============================================================\n");
        /**
         * unomdifiableMap() Example
         */

        log.info("Testing \'.unmodifiableMap()\'");
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("1", "KIA");
        map.put("2", "Volkswagen");
        map.put("3", "Ford");
        map.put("4", "Chevrolet");
        log.info("\tInitial collection: " + map);

        Map<String,String> unmodifiableMap = Collections.unmodifiableMap(map);

        log.info("\tUnmodifiable Map: " + unmodifiableMap);

        map.put("5", "Nissan");
        log.info("\tUnmodifiable Map after adding one more element to map: " + unmodifiableMap);

        log.info("\n============================================================\n");
        /**
         * unmodifiableSet() Example
         */
        log.info("Testing \'.unmodifiableSet()\'");

        Set<String> set = new TreeSet<>();
        Collections.addAll(set, "Pink Floyd", "The Beatles", "The Cure", "Led Zepellin", "Radiohead");

        log.info("\tInitial Set: " + set);
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);

        log.info("\tUnmodifiable Set: " + unmodifiableSet);

        log.info("\tAdding one more element to the initial set...");
        set.add("The Smiths");

        log.info("\tUnmodifiable Set: " + unmodifiableSet);

        log.info("\n============================================================\n");
        /**
         * Testing emptyList, emptyMap, emptySet
         */
        log.info("Testing \'.emptyList()\'");
        List<String> el = Collections.emptyList();

        log.info("\tCreated empty immutable list: " + el);
        log.info("\tTrying to add two items to emptyList...");
        try {
            el.add("A");
            el.add("B");
        } catch (UnsupportedOperationException e) {
            log.error("\tCannot add items to an immutable list");
        }

        log.info("\n============================================================\n");

        log.info("Testing \'.emptyMap()\'");

        Map<String, String> em = Collections.emptyMap();

        log.info("\tCreated empty immutable map: " + em);
        log.info("\tTrying to add two items to emptyMap...");
        try {
            em.put("1","Another item");
        } catch (UnsupportedOperationException e) {
            log.error("\tCannot add items to an immutable map");
        }

        log.info("\n============================================================\n");

        log.info("Testing \'.emptySet()\'");

        Set<String> es = Collections.emptySet();

        log.info("\tCreated empty immutable set: " + es);
        log.info("\tTrying to add two items to emptySet...");
        try {
            es.add("Random item");
        } catch (UnsupportedOperationException e) {
            log.error("\tCannot add items to an immutable set");
        }

        log.info("\n============================================================\n");
        /**
         * Synchronized example
         */
        log.info("Testing \'synchronized\':");
        CollectionsExample ce = new CollectionsExample();
        Thread1 tOne = new Thread1(ce);
        Thread2 tTwo = new Thread2(ce);
        tOne.start();
        tTwo.start();
        //Synchronized execution due to the synchronized keyword. Mutual exclusion.
    }
}
