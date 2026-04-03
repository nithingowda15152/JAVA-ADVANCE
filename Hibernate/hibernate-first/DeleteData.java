package com.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteData {
	public static void main(String[]args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("apple");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();


		//fetch old object
		Student s=em.find(Student.class, 1);
		if(s!=null) {
			//delete object
			em.remove(s);
		}else {
			System.out.println("Id not present");
		}
		et.begin();
		et.commit();
	}
}
