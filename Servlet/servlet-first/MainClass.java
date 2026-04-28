package com.task1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext app =
                new AnnotationConfigApplicationContext("com.task1");

        // Check beans created by Spring Container
        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("---------------------------");

        // Get Person object
        Person p = app.getBean(Person.class);
        p.eat();
        p.sleep();

        System.out.println("---------------------------");

        // Get Animal object
        Animal a = app.getBean(Animal.class);
        a.sound();
        a.run();
    }
}