package com.enroutesystems;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

@Slf4j
public class ListExample {
    public static void main (String[] args) {

        log.info("=========================================================================");
        log.info("Testing ArrayList<>");
        ArrayList<String> list = new ArrayList<String>();
        log.info("\tShowing list:");
        list.add("Dell");
        list.add("HP");
        list.add("Apple");
        list.add("MSI");

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            log.info("\t\t" + itr.next().toString());
        }

        log.info("\tModifying some registers...");

        list.set(1, "Lenovo");
        list.add("HP");

        log.info("\tShowing modified list:");
        itr = list.iterator();
        while (itr.hasNext()) {
            log.info("\t\t" + itr.next().toString());
        }
        log.info("=========================================================================");
        log.info("Testing 'Vector'");

        Vector<String> vec = new Vector<String>();

        log.info("\tAdding elements via add() vector method...");

        vec.add("Java");
        vec.add("C++");
        vec.add("Python");
        vec.add("PHP");

        log.info("\tAdded 4 elements");
        log.info("Current vector:");
        log.info("\t\t" + vec.toString());
        log.info("\tAdding elements via addElement() vector method...");

        vec.addElement("Javascript");
        vec.addElement("Deno");
        vec.addElement("Typescript");

        log.info("\tCurrent vector:");
        log.info("\t\t" + vec.toString());

        log.info("=========================================================================");
        log.info("Testing 'LinkedList'");
        LinkedList<String> al = new LinkedList<String>();
        al.add("Red");
        al.add("Green");
        al.add("Yellow");
        al.add("Blue");
        log.info("\tCurrent LinkedList:");
        log.info("\t\t" + al.toString());
        log.info("\tAdding two items at the beginning of the list...");
        al.addFirst("Orange");
        al.addFirst("Black");
        log.info("\tCurrent LinkedList:");
        log.info("\t\t" + al.toString());
        log.info("\tAdding two items at the end of the list...");
        al.addLast("Gray");
        al.addLast("Pink");
        log.info("\tIteration with Iterator<String>:");

        Iterator<String> iter = al.iterator();
        while (iter.hasNext()) {
            log.info("\t\t" + iter.next());
        }
    }
}
