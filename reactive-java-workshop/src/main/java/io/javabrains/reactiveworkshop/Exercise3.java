package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size

        System.out.println("Execution Started at :- " + (new Date()));
        // toStream on the Flux is blocking the execution and will keep waiting until the last element is emitted
        List<Integer> numList = ReactiveSources.intNumbersFlux().toStream().toList();
        System.out.println(numList);
        System.out.println("Size of Array : " + numList.size());
        System.out.println("Execution Completed at :- " + (new Date()));
    }

}
