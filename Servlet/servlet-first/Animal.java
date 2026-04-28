package com.task1;

import org.springframework.stereotype.Component;

@Component
public class Animal {

    public void sound() {
        System.out.println("Animal makes sound");
    }

    public void run() {
        System.out.println("Animal is running");
    }
}