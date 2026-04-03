package com.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[]args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("apple");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//insert operation
		//create entity class object
		Student s =new Student();
		s.setStuid(3);
		s.setName("Harsha");
		s.setMarks(90.5);
		
		em.persist(s);
		
		et.begin();
		et.commit();
	}
}
