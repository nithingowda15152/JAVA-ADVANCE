package com.second;

import java.util.Scanner;
import javax.persistence.*;

public class UpdataData {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskone");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ID to update:");
        int id = sc.nextInt();

        Employe e = em.find(Employe.class, id);

        if (e != null) {
            System.out.println("Enter new name:");
            e.setEname(sc.next());

            et.begin();
            em.merge(e);
            et.commit();

            System.out.println("Updated Successfully!");
        } else {
            System.out.println("ID not found");
        }
    }
}