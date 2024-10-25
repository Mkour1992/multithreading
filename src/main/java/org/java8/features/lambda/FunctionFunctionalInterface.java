package org.java8.features.lambda;

import java.util.function.Function;

public class FunctionFunctionalInterface {


    public static void main(String[] args) {

        Function<Integer, String> function = (Integer num ) ->{
            if(num>=10)

                return "hey I am greater than 10";

            else
                return "Hey am lessr than 10";
        };

        System.out.println(function.apply(10));
    }
}
