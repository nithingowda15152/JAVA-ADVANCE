package com.second;

import java.util.List;
import java.util.Scanner;
import javax.persistence.*;

public class Login {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskone");
        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Email:");
        String email = sc.next();

        System.out.println("Enter Password:");
        String pass = sc.next();

        Query q = em.createQuery("select e from Employe e where e.email=?1 and e.pass=?2");
        q.setParameter(1, email);
        q.setParameter(2, pass);

        List<Employe> list = q.getResultList();

        if (!list.isEmpty()) {
            System.out.println("Login Success!");
        } else {
            System.out.println("Invalid Credentials");
        }
    }
}