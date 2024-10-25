package org.java8.features.streams;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 30),
            new Person("Alice", 35),  // Duplicate key
            new Person("Bob", 28)     // Duplicate key
        );

        // Convert List to a Map with lists as values to handle duplicates
        Map<String, List<Person>> peopleMap = people.stream()
            .collect(Collectors.groupingBy(Person::getName, 
                    TreeMap::new,  // Use a TreeMap to maintain sorted order
                    Collectors.toList()));  // Store values in a list

        // Print the resulting map
        peopleMap.forEach((key, value) -> 
            System.out.println(key + ": " + value));
    }
}
