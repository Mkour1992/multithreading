package org.java8.features;

import org.java8.features.lambda.Bird;

public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird() {
            @Override
            public void canFly() {
                System.out.println("This is implements Main Class");
            }

        };
bird.canFly();

Bird lambdaBird = () -> {
    System.out.println("This is lambda bird");
};
lambdaBird.canFly();


    }


}