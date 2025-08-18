package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    private Integer id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    // Relation avec Emprunt
    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunts = new HashSet<>();

    // Constructeur vide obligatoire
    public Client() {}

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", emprunts=" + emprunts.size() +
                '}';
    }
}