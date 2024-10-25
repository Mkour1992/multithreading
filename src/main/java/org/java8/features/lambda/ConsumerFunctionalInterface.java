package org.java8.features.lambda;

import java.util.function.Consumer;

public class ConsumerFunctionalInterface {

    public static void main(String[] args) {

        Consumer<String> stringConsumer = (String s) -> System.out.println("This is string as input " + s);

        stringConsumer.accept("HI MEENU");

    }



}
