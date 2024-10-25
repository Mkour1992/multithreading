package org.java8.features.lambda;

import java.util.function.Supplier;

public class SupplierFunctionalInterface {

    public static void main(String[] args) {

     Supplier<String> supplier = () -> "Hi this is Me the supplier functional";

        System.out.println(supplier.get());

    }
}
