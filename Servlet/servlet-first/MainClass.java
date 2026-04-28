package com.first;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[]args) {
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext("com.first");//pass the component class package name in string format
		//how to check Sc is created the object or not
		String[] names=app.getBeanDefinitionNames();
		for(String name:names) {
			System.out.print(name);
		}
		System.out.println("---------------------------");
		//how to get object from SC
		Person p=app.getBean(Person.class);
		System.out.println(p);
		p.eat();
	}
}
