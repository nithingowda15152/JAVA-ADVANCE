package com.task1;

import org.springframework.stereotype.Component;

@Component
public class Person {

    public void eat() {
        System.out.println("Person is eating");
    }

    public void sleep() {
        System.out.println("Person is sleeping");
    }
}