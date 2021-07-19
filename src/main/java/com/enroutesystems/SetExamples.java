package com.enroutesystems;

import java.util.*;

public class SetExamples {
    public static void main(String args[]) {
            /**
             * HashSet Class has not an specific order, and doesn't allow duplicated
             */
            System.out.println("HashSet Example:");
            HashSet<String> hset =
                    new HashSet<String>();
            hset.add("Whale");
            hset.add("Fish");
            hset.add("Clown Fish");
            hset.add("Ballon Fish");
            hset.add("Octopus");

            hset.add(null);
            hset.add(null);

            try { //testing that HashSet doesn't allow repeated data
                    hset.add("Whale");
            } catch(Exception e) {
                    System.err.println(e);
            } finally {
                    System.out.println("\t" + hset);
            }
            /**
             * TreeSet Class stores data in ascending order
             */

            System.out.println("TreeSet Example:");

            TreeSet tree = new TreeSet();
            tree.add(12);
            tree.add(63);
            tree.add(34);
            tree.add(45);

            Iterator<Integer> iterator = tree.iterator();
            System.out.print("\tTree set data: ");

            while (iterator.hasNext()) {
                    System.out.print("\t" + iterator.next() + " ");
            }
            System.out.println();

            if (tree.isEmpty()) {
                    System.out.print("\tTree Set is empty.");
            } else {
                    System.out.println("\tTree Set size: " + tree.size());
            }

            System.out.println("\tFirst data: " + tree.first());

            System.out.println("\tLast data: " + tree.last());

            if (tree.remove(45)) { // remove element by value
                    System.out.println("\tData is removed from tree set");
            } else {
                    System.out.println("\tData doesn't exist!");
            }
            System.out.print("\tNow the tree set contain: ");
            iterator = tree.iterator();

            while (iterator.hasNext()) {
                    System.out.print(iterator.next() + " ");
            }
            System.out.println();
            System.out.println("\tNow the size of tree set: " + tree.size());

            tree.clear();
            if (tree.isEmpty()) {
                    System.out.print("\tTree Set is empty.");
            } else {
                    System.out.println("\tTree Set size: " + tree.size());
            }

            /**
             * In LinkedHashSet, stores data in order of entry, and ensures there are not duplicated.
             */

            System.out.println("\nLinkedHashSet Example:");

            Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
            linkedHashSet.add(20);
            linkedHashSet.add(10);
            linkedHashSet.add(1);
            linkedHashSet.add(5);

            // 20 won't be inserted on the set because it's already inside
            linkedHashSet.add(20);

            // Items are displayed in the order they were inserted
            iterator = linkedHashSet.iterator();
            while (iterator.hasNext()) {
                    System.out.print("\t" + iterator.next() + "-");
            }
    }
}
