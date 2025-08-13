package app;

import entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioPU");
        EntityManager em = emf.createEntityManager();

        // Récupération d'un livre avec ID=1
        Livre livre = em.find(Livre.class, 1);
        System.out.println(livre);

        em.close();
        emf.close();
    }
}