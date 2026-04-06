package com.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateData {
	public static void main(String[]args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("apple");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();


		//new obj=new row
		//modify old row=fetch old row of obj first
		Student s=em.find(Student.class, 1);
		if(s!=null) {
			//set the new data
			s.setName("Nikhitha");
			//call merge(entity obj)
			em.merge(s);
		}else {
			System.out.println("Id not present");
		}
		et.begin();
		et.commit();
	}
}
