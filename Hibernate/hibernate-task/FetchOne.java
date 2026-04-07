package com.second;

import java.util.Scanner;
import javax.persistence.*;

public class FetchOne {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskone");
        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ID:");
        int id = sc.nextInt();

        Employe e = em.find(Employe.class, id);

        if (e != null) {
            System.out.println(e.getEmpid() + " " + e.getEname() + " " + e.getSalary());
        } else {
            System.out.println("ID not found");
        }
    }
}