package com.enroutesystems;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class MapExamples {
    public static void main(String args[]) {

        /**
         * With Hashmap we can store key:value pairs, like in a JSON,
         * this class doesn't keep the insertion order
         */

        log.info("Hashmap Example: ");

        HashMap<Integer,String> hashMap=new HashMap<Integer,String>();
        hashMap.put(1,"Horse");
        hashMap.put(2,"Chicken");
        hashMap.put(3,"Duck");
        hashMap.put(4,"Cow");

        log.info("\tIterating with for bucle...");

        for(Map.Entry m : hashMap.entrySet()){
            log.info("\t\tKey is: " + m.getKey()+" & value is: " + m.getValue());
        }

        log.info("\tIterating with EntrySet Iterator");

        Set entrySet = hashMap.entrySet();

        Iterator it = entrySet.iterator();

        log.info("\t\tHashMap Pairs: ");
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            log.info("\t\tKey is: "+me.getKey() +
                    " & " +
                    " value is: "+me.getValue());
        }

        /**
         * LinkedHashMap is an implementation of hashmap, but in this class, the insertion order is kept.
         */
        log.info("LinkedHashMap Example:");
        LinkedHashMap<Integer,String> lhm=new LinkedHashMap<Integer,String>();

        lhm.put(1,"Owl");
        lhm.put(2,"Mockingbird");
        lhm.put(3,"Crow");

        for(Map.Entry m:lhm.entrySet()) {
            log.info("\tKey is: "+m.getKey() +
                    " & " +
                    " value is: "+m.getValue());
        }
        /**
         * TreeMap:
         * Cannot have any null keys, and maintains ascending order
         */
        TreeMap<Integer,String> treemap=new TreeMap<Integer,String>();
        treemap.put(1,"Horse");
        treemap.put(2,"Chicken");
        treemap.put(3,"Duck");
        treemap.put(4,"Cow");

        for(Map.Entry m:treemap.entrySet()) {
            log.info("\t\tKey is: "+m.getKey() +
                    " & " +
                    " value is: "+m.getValue());
        }
        treemap.remove(2);
        log.info("Applying treemap.delete(2)");
        for(Map.Entry m:treemap.entrySet()) {
            log.info("\t\tKey is: "+m.getKey() +
                    " & " +
                    " value is: "+m.getValue());
        }

        log.info("\tTreemap.descendingMap: " + treemap.descendingMap());

        //Returns key-value pairs whose keys are less than or equal to the specified key.
        log.info("\tTreemap.headMap: " + treemap.headMap(3,true));

        //Returns key-value pairs whose keys are greater than or equal to the specified key.
        log.info("\tTreemap.tailMap: " + treemap.tailMap(3,true));

        //Returns key-value pairs exists in between the specified key.
        log.info("\tTreemap.subMap: " + treemap.subMap(1, false, 3, true));
    }
}
