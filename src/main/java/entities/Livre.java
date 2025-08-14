package entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "livre")  // correspond exactement au nom de la table dans la BDD
public class Livre {

    @Id
    private Integer id;
    private String titre;
    private String auteur;

    public Livre() {} // obligatoire pour JPA

    // Relation entre Livre et Emprunt
    @ManyToMany(mappedBy = "livres")
    private List<Emprunt> emprunts;

    // Getters et setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }
}