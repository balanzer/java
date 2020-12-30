package com.mtvhere.java;

public class LambdaExamples {

    public static void main(final String args[]) {
        final Runnable r1 = () -> {
            System.out.println("hello world");
        };

        r1.run();

        final MyGreetings greetings = (name) -> {
            return "Hello " + name;
        };
        System.out.println("" + greetings.sayHello("Murali"));

    }


    interface MyGreetings {
        public String sayHello(String name);
    }

}
