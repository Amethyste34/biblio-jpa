package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "emprunt")
public class Emprunt {
    @Id
    private Integer id;

    @Column(name = "DATE_DEBUT")
    private LocalDate dateDebut;

    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    @Column(name = "DELAI")
    private Integer delai;

    // Relation avec Client
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT") // Foreign key
    private Client client;

    // Relation avec Livre
    @ManyToMany
    @JoinTable(
            name = "compo",
            joinColumns = @JoinColumn(name = "ID_EMP"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV")
    )
    private Set<Livre> livres = new HashSet<>();

    // Constructeur vide
    public Emprunt() {}

    // Getters et Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public Integer getDelai() { return delai; }
    public void setDelai(Integer delai) { this.delai = delai; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Set<Livre> getLivres() { return livres; }
    public void setLivres(Set<Livre> livres) { this.livres = livres; }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", delai=" + delai +
                ", client=" + (client != null ? client.getNom() : "null") +
                ", nbLivres=" + livres.size() +
                '}';
    }
}