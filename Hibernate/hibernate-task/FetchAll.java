package com.second;

import java.util.List;
import javax.persistence.*;

public class FetchAll {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskone");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select e from Employe e");

        List<Employe> list = q.getResultList();

        for (Employe e : list) {
            System.out.println(e.getEmpid() + " " + e.getEname() + " " + e.getSalary());
        }
    }
}