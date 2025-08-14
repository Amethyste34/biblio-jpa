package app;

import entities.Client;
import entities.Emprunt;
import entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioPU");
        EntityManager em = emf.createEntityManager();

        try {
            // 1️⃣ Récupérer un emprunt par ID et afficher les livres associés
            int idEmprunt = 1; // exemple
            Emprunt emprunt = em.find(Emprunt.class, idEmprunt);
            if (emprunt != null) {
                System.out.println("Emprunt trouvé : " + emprunt);
                System.out.println("Livres associés :");
                for (Livre livre : emprunt.getLivres()) {
                    System.out.println(" - " + livre);
                }
            } else {
                System.out.println("Aucun emprunt trouvé pour l'ID " + idEmprunt);
            }

            System.out.println("\n-----------------------------------\n");

            // 2️⃣ Récupérer tous les emprunts d’un client donné
            int idClient = 1; // exemple
            Client client = em.find(Client.class, idClient);
            if (client != null) {
                System.out.println("Client trouvé : " + client);
                System.out.println("Emprunts du client :");
                for (Emprunt e : client.getEmprunts()) {
                    System.out.println(" - " + e);
                }
            } else {
                System.out.println("Aucun client trouvé pour l'ID " + idClient);
            }

        } finally {
            em.close();
            emf.close();
        }
    }
}