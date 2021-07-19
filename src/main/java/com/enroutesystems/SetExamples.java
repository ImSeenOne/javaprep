package com.enroutesystems;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class SetExamples {
    public static void main(String args[]) {
            /**
             * HashSet Class has not an specific order, and doesn't allow duplicated
             */
            log.info("HashSet Example:");
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
                    log.error(e.toString());
            } finally {
                    log.info("\t" + hset);
            }
            /**
             * TreeSet Class stores data in ascending order
             */

            log.info("TreeSet Example:");

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

            if (tree.isEmpty()) {
                    System.out.print("\tTree Set is empty.");
            } else {
                    log.info("\tTree Set size: " + tree.size());
            }

            log.info("\tFirst data: " + tree.first());

            log.info("\tLast data: " + tree.last());

            if (tree.remove(45)) { // remove element by value
                    log.info("\tData is removed from tree set");
            } else {
                    log.info("\tData doesn't exist!");
            }
            System.out.print("\tNow the tree set contain: ");
            iterator = tree.iterator();

            while (iterator.hasNext()) {
                    System.out.print(iterator.next() + " ");
            }
            log.info("\tNow the size of tree set: " + tree.size());

            tree.clear();
            if (tree.isEmpty()) {
                    System.out.print("\tTree Set is empty.");
            } else {
                    log.info("\tTree Set size: " + tree.size());
            }

            /**
             * In LinkedHashSet, stores data in order of entry, and ensures there are not duplicated.
             */

            log.info("\nLinkedHashSet Example:");

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
