package com.enroutesystems.collectionExamples;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ArraysExample {
    public static void main(String[] args) {
        log.info("Testing 'Arrays.sort()'");
        int[] array = {36,58,45,9,7,21,35,46,84,32,81,21,32,8};
        Arrays.sort(array);
        log.info("\tElements of array sorted in ascending order: ");
        for (int i = 0; i < array.length; i++){
            log.info("\t" + array[i]);
        }
        log.info("============================================================");
        log.info("Testing 'Arrays.fill()'");
        int arr[] = new int[] {1,2,3,4,5,6,7,8,9};

        log.info("\tActual values: ");
        for (int value : arr) {
            log.info("\t\tValue: " + value);
        }

        Arrays.fill(arr, 18);

        log.info("\tNew values after using fill() method: ");
        for (int value : arr) {
            log.info("\t\tValue: " + value);
        }

        log.info("============================================================");
        log.info("Testing 'Arrays.asList()'");
        String arrAsL[] = { "Math", "History", "Geography", "Biology", "Chemistry", "Physics", "Law & Rights"};
        log.info("Array before conversion: "+ Arrays.toString(arrAsL));
        List<String> list =  Arrays.asList(arrAsL);
        log.info("Array after conversion: " + list);
    }
}
