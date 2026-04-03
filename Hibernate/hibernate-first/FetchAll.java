package com.first;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FetchAll {
	public static void main(String[]args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("apple");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//JDBC:sql(Syntax is diff for didd DB)
		//Hibernate:hql(hibernate ql)/jpql(java persistense ql)[Syntax is same for all DB]
		
		//SQL:select * from tablename
		//hql:select ref-var from EntityClassName ref-var;
		
		Query q=em.createQuery("select stu from Student stu");
		//all objects comes in List Format
		//too get that list call getResultList()present in Query
		List<Student> allStudent=q.getResultList();
		for(Student s:allStudent) {
			System.out.println(s.getStuid()+" "+s.getName()+" "+s.getMarks());
		}
		System.out.println("----------------------------------------------------");
		Query q1=em.createQuery("select stu from Student stu where stu.marks>85.0");
		List<Student> list=q1.getResultList();
		for(Student s:list) {
			System.out.println(s.getStuid()+" "+s.getName()+" "+s.getMarks());
		}
		System.out.println("------------------------------------------------------");
		//Instead of giving marks directly use delimeter[delimeter delimeterNumber]
		Query q2=em.createQuery("select stu from Student stu where stu.marks>?1");
		q2.setParameter(1, 89.0);
		List<Student> list2=q2.getResultList();
		for(Student s:list2) {
			System.out.println(s.getStuid()+" "+s.getName()+" "+s.getMarks());
		}
		et.begin();
		et.commit();
	}
}