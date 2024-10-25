package org.java8.features.streams;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.List.of;

public class StreamExample {

    public static void main(String[] args) {

        List<Integer> salaryList = new ArrayList<>();

        salaryList.add(2100);
        salaryList.add(3100);
        salaryList.add(5100);
        salaryList.add(26100);
        salaryList.add(74280);
        salaryList.add(2800);
        salaryList.add(9000);
        salaryList.add(26900);


        //Get salary greater than 3000
        int count = 0;
        for (Integer salary : salaryList) {
            if (salary > 3000) count++;


        }

        // System.out.println("Employees with salary greater than 3000 is" + count);

//Performing same operation with Streams


       // System.out.println("Employees with salary greater than 3000 with stream operation is " + salaryList.stream().filter((salary) -> salary > 3000).count());

        List<String> stringList = new ArrayList<>();
        stringList.add("HELO");
        stringList.add("MY");
        stringList.add("NAME");
        stringList.add("IS");
        stringList.add("IS");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(14);
        integerList.add(17);
        integerList.add(10);
        integerList.add(34);
        integerList.add(5);
        integerList.add(5);
        integerList.add(4);
        integerList.add(4);
        integerList.add(5);

        // stringList.stream().map((input)->input.toLowerCase()).forEach(System.out::println);
        // System.out.println(stringList.stream().filter((input) ->input.length()>3).collect(Collectors.toList()));

        // System.out.println(stringList.stream().map((input) ->input.toLowerCase()).collect(Collectors.toList()));


        //  1. Use the Stream API to filter even numbers from a list and print them.

       // integerList.stream().filter(i->i%2==0).forEach(System.out::println);
        //integerList.stream().filter((input)->(input%2==0)).forEach(System.out::println);


        //Given a list of integers, find out all the numbers starting with 1 using Stream functions?

      //  integerList.stream().filter(input->input.toString().startsWith("1")).forEach(System.out::println);


        //  integerList.stream().map((input)->input.toString()).filter((input)->input.startsWith("1")).forEach(System.out::println);
        //  integerList.stream().filter((input)->(input%2==0)).forEach(System.out::println);

//How to find duplicate elements in a given integers list in java using Stream functions?
        //integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(Map.Entry::getKey).forEach(System.out::println);


        // System.out.println(integerList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList()));
        //4. Given the list of integers, find the first element of the list using Stream functions?

      //  integerList.stream().findFirst().ifPresent(System.out::println);





        // integerList.stream().findFirst().ifPresent(System.out::println);

        //5. Given a list of integers, find the total number of elements present in the list using Stream functions?



        //System.out.println(integerList.stream().count());


//Given a list of integers, find the maximum value element present in it using Stream functions?

       // integerList.stream().min(Comparator.reverseOrder()).ifPresent(System.out::println);
        //integerList.stream().max(Integer::compareTo).ifPresent(System.out::println);











        //  integerList.stream().max(Integer::compareTo).ifPresent(System.out::println);


        //   7. Given a String, find the first non-repeated character in it using Stream functions?

        String input = "swiss";


// input.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry ->entry.getValue() == 1).map(entry ->entry.getKey()).findFirst().ifPresent(System.out::println);
        // System.out.println(integerList.stream().collect(Collectors.partitioningBy(i->i%2==0)).entrySet().stream().collect(Collectors.toList()));

        //8. Given a String, find the first repeated character in it using Stream functions?



        // input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).findFirst().ifPresent(System.out::println);
//9. Given a list of integers, sort all the values present in it using Stream functions?
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
//myList.stream().sorted().forEach(System.out::println);

//10. Given a list of integers, sort all the values present in it in descending order using Stream functions?

        // myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        //    11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

        integerList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).values().stream().anyMatch(count1 ->count1>1);
        //System.out.println(integerList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).values().stream().anyMatch(count1 -> count1 > 2));
//13. Write a Java 8 program to concatenate two Streams?

//    Stream<Integer> concated =   Stream.concat(myList.stream() ,integerList.stream());
//    concated.forEach(System.out::println);


        //14. Java 8 program to perform cube on list elements and filter numbers greater than 50.

        //myList.stream().map((num) ->num*num*num).filter(num->num>50).forEach(System.out::println);

//15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
        int[] a= {2,7,4,5,6};
        Arrays.sort(a);
        IntStream intStream = Arrays.stream(a);
//How to use map to convert object into Uppercase in Java 8?
        stringList.stream().map(String::toUpperCase).forEach(System.out::println);

        // stringList.stream().map(String::toUpperCase).forEach(System.out::println);

//17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?

// How to count each element/word from the String ArrayList in Java8?

        Map<String, Long> mapOfString = stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(mapOfString);

        //19. How to find only duplicate elements with its count from the String ArrayList in Java8?
        // stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).forEach(System.out::println);
//20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?


        // Write a Program to find the Maximum element in an array? we can do with.max()
        //22. Write a program to print the count of each character in a String? can be done using grouping

        List<String> strings = Arrays.asList("meenu", "is", "my", "name");
//        Optional<List<String>> optionalStrings =  Optional.ofNullable(strings);
//        optionalStrings.filter(list ->!list.isEmpty()).ifPresent(System.out::println);

        List<Person> personList = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30),
                new Person("Alice", 35),  // Duplicate key
                new Person("Bob", 28));// Duplicate key




//2 https://github.com/rohitchavan-git/Java-8-Interview-Sample-Coding-Questions


        /**
         * Separate odd and even numbers in a list of integers.
         *
         * Given a list of integers, write a Java 8 program to separate
         * the odd and even numbers into two separate lists.
         */

        // separationOfEvenOddNumberInList();
        integerList.stream().collect(Collectors.collectingAndThen(Collectors.partitioningBy(i->i%2==0), Map::values)).forEach(System.out::println);

          integerList.stream().collect(Collectors.collectingAndThen(Collectors.partitioningBy(i->i%2==0), Map::values)).forEach(System.out::println);


        // separationOfEvenOddNumberInMap();
        /**
         * Remove duplicate elements from a list using Java 8 streams
         *
         * Write a Java 8 program to remove duplicate elements from a list
         * using the stream API and lambda expressions.
         */

        //removeDuplicateFromList();

        /*List<Integer> duplicateList = List.of(1, 2, 3, 4, 6, 2, 4, 2, 1, 6);

        duplicateList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey()).collect(Collectors.toList()).stream().forEach(System.out::println);*/
/**
 * Find the frequency of each character in a string using Java 8 streams
 *
 * Write a Java 8 program to find the frequency of each character in
 * a given string using the stream API and collectors.
 */
        //characterFrequency();

        //List<String> strList = List.of("Meenu","is","kour");
        String oneWord = "Meenu is Meenu";
//Arrays.stream(oneWord.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().forEach(System.out::println);
        //oneWord.chars().mapToObj(s->(char)s).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().forEach(System.out::println);
        /**
         * Sort a given list of decimals in reverse order
         *
         * Write a Java 8 program to sort a given list of decimal numbers in reverse order.
         */

        List<Integer> intList = of(1, 2, 3, 4, 5, 6, 7);
//integerList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        //intList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        // reverseSortedList();

        /**
         * Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
         *
         * Given a list of strings, write a Java 8 program to join the strings
         * with '[' as a prefix, ']' as a suffix, and ',' as a delimiter.
         */

        List<String> languageList = of("java", "c++", "c", "C sharp", "python", "kotlin", "scala");
        // System.out.println(languageList.stream().collect(Collectors.joining(",","[","]")));

        //joinListOfStrings();

        /**
         * Print the numbers from a given list of integers that are multiples of 5
         *
         * Write a Java 8 program to print the numbers from a given list of integers that are multiples of 5.
         */

        //multipleOf5();

        List<Integer> multiples = of(5, 10, 3, 60, 34, 78);

        //  multiples.stream().filter(num->num%5 ==0).forEach(System.out::println);


        /**
         * Find the maximum and minimum of a list of integers
         * Given a list of integers, write a Java 8 program to find the maximum and minimum numbers in the list.
         */
integerList.stream().collect(Collectors.summarizingInt(i->i.intValue())).getMax();
        // minMaxFromList();
        //  IntSummaryStatistics intSummaryStatistics = intList.stream().collect(Collectors.summarizingInt(Integer::intValue));
//        System.out.println(intSummaryStatistics.getMax());
//        System.out.println(intSummaryStatistics.getMin());
//        intList.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
//        intList.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

        /**
         * Merge two unsorted arrays into a single sorted array using Java 8 streams
         * Write a Java 8 program to merge two unsorted arrays into a single-sorted array using the stream API.
         */
//        int [] randomNumbers ={12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
//        int [] randomNumber2 = {4, 3, 2, 5, 6, 78, 98, 53, 90};
        // Arrays.stream(IntStream.concat(Arrays.stream(randomNumbers),Arrays.stream(randomNumber2)).sorted().toArray()).forEach(System.out::println);

        //  mergeUnsortedArrayIntoSorted();

        /**
         * Merge two unsorted arrays into a single sorted array without duplicates
         * Write a Java 8 program to merge two unsorted arrays into a single-sorted array without duplicates.
         */
        //  mergeUnsortedArrayIntoSortedWithoutDuplicate();

        //  Arrays.stream(IntStream.concat(Arrays.stream(randomNumbers),Arrays.stream(randomNumber2)).sorted().distinct().toArray()).forEach(System.out::println);
        /**
         * Get the three maximum and three minimum numbers from a given list of integers
         *
         * Write a Java 8 program to get the three maximum and three minimum numbers from a given list of integers.
         */

        // min3max3();
//intList.stream().sorted(Comparator.naturalOrder()).limit(3).forEach(System.out::println);
//intList.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);


        /**
         * Find the sum of all digits of a number in Java 8
         *
         * Write a Java 8 program to find the sum of all digits of a given number.
         *
         */
int number =12345;
        Stream.of(String.valueOf(number).split(""))  // Convert number to String and split into digits
                .mapToInt(Integer::parseInt)                           // Convert each digit back to an int
                .sum();
        Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).sum();
        //   sumOf();
        //  System.out.println(intList.stream().mapToInt(Integer::intValue).sum());

        // System.out.println( intList.stream().mapToInt(Integer::intValue).summaryStatistics().getSum());
        /**
         * Find the second-largest number in an integer array
         *
         * Write a Java 8 program to find the second-largest number in an integer array.
         */
        //  intList.stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().stream().forEach(System.out::println);
        // intList.stream().sorted(Comparator.naturalOrder()).
        // secondLargestNumberFromList();
        /**
         * Sort a list of strings according to the increasing order of their length
         *
         * Write a Java 8 program to sort a given list of strings according to the increasing order of their length.
         */
        //sortByLengthOfList();
//      List<String> nameArray = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
//      nameArray.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);}

        /**
         * Find the common elements between two arrays
         *
         * Write a Java 8 program to find the common elements between two arrays using streams.
         */
//        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<Integer> twoToTen = of(2, 3, 4, 5, 6, 7, 8, 9, 10);
//        oneToTen.stream().filter(x ->twoToTen.contains(x)).forEach(System.out::println);


        /**
         * Reverse each word of a string using Java 8 streams
         *
         * Write a Java 8 program to reverse each word of a given string using the stream API and lambda expressions
         */

     // List<String> nameArray = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
      //nameArray.stream().map(word ->new StringBuffer(word).reverse()).forEach(System.out::println);

       // String stmt = "java is OOP language";
        String stmt ="madam";
       // System.out.println(Arrays.stream(stmt.split(" ")).map(word -> new StringBuffer(word).reverse()).toString().equals(stmt));

//      nameArray.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);}

        /**
         * Find the sum of the first 10 natural numbers
         *
         * Write a Java 8 program to find the sum of the first 10 natural numbers using streams.
         */
        //System.out.println(IntStream.rangeClosed(1,10).sum());

        /**
         * Reverse an integer array
         *
         * Write a Java 8 program to reverse an integer array.
         */

        int [] randomNumbers ={12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
     //  IntStream.range(0,randomNumbers.length).mapToObj(i->randomNumbers[randomNumbers.length-1-i]).forEach(System.out::println);

        /**
         * Find the most repeated element in an array
         *
         * Write a Java 8 program to find the most repeated element in an array.
         */
         int[] elements = {2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};

         Arrays.stream(elements).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

    //    System.out.println(Arrays.stream(elements).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

        //mostRepeatedElement();

        /**
         * Check if a string is a palindrome using Java 8 streams
         *
         * Write a Java 8 program to check if a given string is a palindrome using the stream API and lambda expressions.
         */

        String  check = "Madam";
        String refined = check.toLowerCase();
        IntStream.range(0,refined.length()/2).allMatch(i->refined.charAt(i)==refined.charAt(refined.length()-i-1));



       String clearStr= check.toLowerCase();

      //  System.out.println(IntStream.range(0,clearStr.length()/2).allMatch(i->clearStr.charAt(i) ==clearStr.charAt(clearStr.length()-i-1)));

        //checkIsTheStringPalindrome();
        /**
         * Find strings in a list that start with a number
         *
         * Given a list of strings, write a Java 8 program to find the strings that start with a number.
         */
        String [] words= {"rohit","foo","nemo","target1","12Target","2robot"};
        Arrays.asList(words).stream().filter(word->Character.isDigit(word.charAt(0))).forEach(System.out::println);
Arrays.asList(words).stream().filter(word->Character.isDigit(word.charAt(0))).forEach(System.out::println);
/**
 * Print duplicate characters in a string
 * Write a Java 8 program to print the duplicate characters in a string.
 */

      String dup = "Meenuukko";
      //dup.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).forEach(System.out::println);


        /**
         * Find the first repeated character in a string
         * Write a Java 8 program to find the first repeated character in a string.
         */
        dup.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),  LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()==1).map(Map.Entry::getKey).findFirst().ifPresentOrElse(System.out::println, ()-> System.out.println("Not dound") );
        /**
         * Find the first non-repeated character in a string
         *
         * Write a Java 8 program to find the first non-repeated character in a string.
         */


        /**
         * Print the first 10 odd numbers
         *
         * Write a Java 8 program to print the first 10 odd numbers.
         */
        IntStream.range(1,10).filter(i->i%2!=0).forEach(System.out::println);
     // IntStream.rangeClosed(1,10).filter(i->i%2!=0).forEach(System.out::println);

        /**
         * Get the last element of an array
         *
         * Write a Java 8 program to get the last element of an array.
         */

        int[] intArray = {7,1,2,3,4,5,6,7};


        IntStream.range(0,intArray.length).filter(i->i==intArray.length-1).map(i->intArray[i]).forEach(System.out::println);

        IntStream.range(0,intArray.length).filter(i->i==intArray.length-1).map(i->intArray[i]).forEach(System.out::println);
        System.out.println( Arrays.stream(intArray).boxed().reduce((first,second) ->second).orElse(-1));

        /**
         * Calculate the age of a person in years
         *
         * Write a Java 8 program to calculate the age of a person in years given their birthday.
         */

        LocalDate birthDate =LocalDate.of(1992,04,11);
        LocalDate now =LocalDate.now();
        int age = Period.between(birthDate,now).getYears();
        System.out.println("Age is"+age);
       // calculatePersonAgeInYear();

        //Sum of all digits in a number
        int number1 = 1234;
        String.valueOf(number1).chars().map(Character::getNumericValue).sum();
        System.out.println(String.valueOf(number1).chars().map(Character::getNumericValue).sum());

        //Armstrong number
//153 , 1^3+5^3+3^3 =153
        int n =153;
        int len = String.valueOf(n).length();
        System.out.println(String.valueOf(n).chars().map(Character::getNumericValue).map(ch->(int)Math.pow(ch,len)).sum());
boolean isPrime = IntStream.rangeClosed(2,n/2).noneMatch(x->n%x==0);
        System.out.println("prime"+isPrime);
    }


}
