package org.java8.features;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEvaluation {


//   Question 1 Write a program to print the count of each character in a String?
//    Input: String s = "string data to count each character";
//    Output: {s=1, t=5, r=3, i=1, n=2, g=1,  =5, d=1, a=5, o=2, c=4, u=1, e=2, h=2}

    public static void main(String[] args) {
        String s = "string data to count each character";

//        s.chars().mapToObj(string -> (char) string).
//                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().forEach(System.out::println);


        //Question 2:

        //Reverse each word of a string using Java 8 streams?
        //
        //String str = "Java Concept Of The Day";
        //
        //avaJ tpecnoC fO ehT yaD


        String input = "Java Concept Of The Day";
        Arrays.stream(input.split(" ")).map(word->new StringBuffer(word).reverse()).collect(Collectors.joining(" "));



        //Question 3 -02/10/2024
        //Write a Java 8 program to calculate the age of a person in years given their birthday.

        LocalDate birthDate = LocalDate.of(1992,04,11);
        LocalDate now = LocalDate.now();
        System.out.println("Age is"+ Period.between(now,birthDate).getYears());

//Question 4
        //Write a program to find the only duplicate count list in the List.
        //"Java", "Spring", "JPA", "Java", "Cloud", "JPA"

        List<String> strList = List.of("Java", "Spring", "JPA", "Java", "Cloud", "JPA");

        strList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).forEach(System.out::println);

        Predicate<List> listPredicate = List::isEmpty;
        listPredicate.test(strList);





    }


        Supplier<String> supplier = ()-> {
            return "This is a supplier" ;};

    Consumer consumer =(a)->{
        System.out.println("hello");
    };

    Function function = ( x)->
    {
        return x;
    };



}
