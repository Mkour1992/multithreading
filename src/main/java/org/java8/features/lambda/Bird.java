package org.java8.features.lambda;


@FunctionalInterface
public interface Bird {

   void canFly();

   static  void staticMethod()
   {
      System.out.println("Am a static method");
   }
   default int defaultMethod()
   {
      System.out.println("Am a Default method");
      return 1;
   }

    String toString();
}
