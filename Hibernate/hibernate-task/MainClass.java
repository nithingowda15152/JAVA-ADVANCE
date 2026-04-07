package com.second;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[]args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("taskone");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Scanner sc = new Scanner(System.in);

        Employe e = new Employe();

        System.out.println("Enter ID:");
        e.setEmpid(sc.nextInt());

        System.out.println("Enter Name:");
        e.setEname(sc.next());

        System.out.println("Enter Salary:");
        e.setSalary(sc.nextDouble());

        System.out.println("Enter Phone:");
        e.setPhonenum(sc.nextLong());

        System.out.println("Enter Email:");
        e.setEmail(sc.next());

        System.out.println("Enter Password:");
        e.setPass(sc.next());

        em.persist(e);

        System.out.println("Inserted Successfully!");
		
		et.begin();
		et.commit();
	}
}
