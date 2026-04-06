package com.second;

import java.util.List;
import java.util.Scanner;
import javax.persistence.*;

public class FetchBySalary {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskone");
        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter salary:");
        double sal = sc.nextDouble();

        Query q = em.createQuery("select e from Employe e where e.salary > ?1");
        q.setParameter(1, sal);

        List<Employe> list = q.getResultList();

        for (Employe e : list) {
            System.out.println(e.getEmpid() + " " + e.getEname() + " " + e.getSalary());
        }
    }
}