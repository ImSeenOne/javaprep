package com.enroutesystems;

import java.util.*;

public class CollectionsExample {

    public synchronized void print(int n){
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

    }

    public synchronized void isEven(int n) {
        String word = (n % 2 == 0) ? "" : "not ";
        System.out.println("The number " + n + " is " + word + "even");
    }

    public synchronized void higherThan100(int n) {
        String word = (n > 100) ? "" : "not ";
        System.out.println("The number " + n + " is " + word + "greater than 100");
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

class TestExample {
    public static void main (String args[]) {

        /**
         * java.util.Collections.unmodifiablelList() Example
         */
        System.out.println("Testing \'.unmodifiableList()\':");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Sanda", "MuayThai", "KickBoxing", "JiuJitsu");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println("\tUnmodifiable List: " + unmodifiableList);
        System.out.println("\tAdding element to an already created unmodifable list...");
        list.add("Box");
        System.out.println("\tPrinting unmodifiable list after trying to add new element: " + unmodifiableList);

        System.out.println("\n============================================================\n");
        /**
         * unomdifiableMap() Example
         */

        System.out.println("Testing \'.unmodifiableMap()\'");
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("1", "KIA");
        map.put("2", "Volkswagen");
        map.put("3", "Ford");
        map.put("4", "Chevrolet");
        System.out.println("\tInitial collection: " + map);

        Map<String,String> unmodifiableMap = Collections.unmodifiableMap(map);

        System.out.println("\tUnmodifiable Map: " + unmodifiableMap);

        map.put("5", "Nissan");
        System.out.println("\tUnmodifiable Map after adding one more element to map: " + unmodifiableMap);

        System.out.println("\n============================================================\n");
        /**
         * unmodifiableSet() Example
         */
        System.out.println("Testing \'.unmodifiableSet()\'");

        Set<String> set = new TreeSet<>();
        Collections.addAll(set, "Pink Floyd", "The Beatles", "The Cure", "Led Zepellin", "Radiohead");

        System.out.println("\tInitial Set: " + set);
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);

        System.out.println("\tUnmodifiable Set: " + unmodifiableSet);

        System.out.println("\tAdding one more element to the initial set...");
        set.add("The Smiths");

        System.out.println("\tUnmodifiable Set: " + unmodifiableSet);

        System.out.println("\n============================================================\n");
        /**
         * Testing emptyList, emptyMap, emptySet
         */
        System.out.println("Testing \'.emptyList()\'");
        List<String> el = Collections.emptyList();

        System.out.println("\tCreated empty immutable list: " + el);
        System.out.println("\tTrying to add two items to emptyList...");
        try {
            el.add("A");
            el.add("B");
        } catch (UnsupportedOperationException e) {
            System.err.println("\tCannot add items to an immutable list");
        }

        System.out.println("\n============================================================\n");

        System.out.println("Testing \'.emptyMap()\'");

        Map<String, String> em = Collections.emptyMap();

        System.out.println("\tCreated empty immutable map: " + em);
        System.out.println("\tTrying to add two items to emptyMap...");
        try {
            em.put("1","Another item");
        } catch (UnsupportedOperationException e) {
            System.err.println("\tCannot add items to an immutable map");
        }

        System.out.println("\n============================================================\n");

        System.out.println("Testing \'.emptySet()\'");

        Set<String> es = Collections.emptySet();

        System.out.println("\tCreated empty immutable set: " + es);
        System.out.println("\tTrying to add two items to emptySet...");
        try {
            es.add("Random item");
        } catch (UnsupportedOperationException e) {
            System.err.println("\tCannot add items to an immutable set");
        }
        System.out.println("\n============================================================\n");
        /**
         * Synchronized example
         */
        System.out.println("Testing \'synchronized\':");
        CollectionsExample ce = new CollectionsExample();
        Thread1 tOne = new Thread1(ce);
        Thread2 tTwo = new Thread2(ce);
        tOne.start();
        tTwo.start();
        //Synchronized execution due to the synchronized keyword. Mutual exclusion.
    }
}
