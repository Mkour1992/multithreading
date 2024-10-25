package org.java8.features.lambda;

import java.util.function.Predicate;

public class PredicateFunctionalInterface {


    public static void main(String[] args) {

        Predicate<Integer> isEven  = (Integer val) -> val % 2 == 0;

        System.out.println(isEven.test(100));
    }
}
