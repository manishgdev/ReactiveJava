package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream()
                .forEach(n -> System.out.println(n));

        System.out.println("--------------------------------------");
        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
                .filter(f -> f < 5)
                .forEach(n -> System.out.println(n));

        System.out.println("--------------------------------------");
        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(f -> f > 5)
                .skip(1)
                .limit(2)
                .forEach(n -> System.out.println(n));

        System.out.println("--------------------------------------");
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        Integer num = StreamSources.intNumbersStream().filter(n -> n > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(num);

        System.out.println("--------------------------------------");
        // Print first names of all users in userStream
        // TODO: Write code here
//        StreamSources.userStream().forEach(u -> System.out.println(u.getFirstName()));
        StreamSources.userStream().map(u -> u.getFirstName()).forEach(u -> System.out.println(u));

        System.out.println("--------------------------------------");
        // Print first names in userStream for users that have IDs from number stream
//        StreamSources.intNumbersStream()
//                .flatMap(n -> StreamSources.userStream().filter(u -> u.getId() == n))
//                .map(u -> u.getFirstName())
//                .forEach(u -> System.out.println(u));

        // Both the solutions work
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(n -> u.getId() == n))
                .map(u -> u.getFirstName())
                .forEach(u -> System.out.println(u));

    }

}
