package com.second;

import java.util.Scanner;
import javax.persistence.*;

public class DeleteData {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskone");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ID to delete:");
        int id = sc.nextInt();

        Employe e = em.find(Employe.class, id);

        if (e != null) {
            et.begin();
            em.remove(e);
            et.commit();

            System.out.println("Deleted Successfully!");
        } else {
            System.out.println("ID not found");
        }
    }
}