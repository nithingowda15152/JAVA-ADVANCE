package com.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FindData {
	public static void main(String[]args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("apple");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//find one row of data based on id
		//use find(EntityClassName.clss,pk-value)
		Student st=em.find(Student.class, 1);
		if(st!=null) {
		System.out.println(st.getStuid()+" "+st.getName()+" "+st.getMarks());
		}else {
			System.out.println("Id not present");
		}
		
		et.begin();
		et.commit();
	}
}
