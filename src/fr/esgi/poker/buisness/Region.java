package fr.esgi.poker.buisness;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Region {

    private String nom;
    private List<Departement> departements = new ArrayList<>();

    public Region() {
    }

    public Region(String nom) {
            this();
            this.nom = nom;
    }

    public String getNom() {
            return nom;
    }

    public void setNom(String nom) {
            this.nom = nom;
    }

    public List<Departement> getDepartements() {
            return departements;
    }

    public void setDepartements(List<Departement> departements) {
            this.departements = departements;
    }

    // Ces méthodes sont nécessaires car nous allons
    // utiliser un ensemble de régions
    // Java invoquera ces méthodes pour tester la
    // présence de l'objet dans l'ensemble
    @Override
    public int hashCode() {
            return Objects.hash(nom);
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            Region other = (Region) obj;
            return Objects.equals(nom, other.nom);
    }

    @Override
    public String toString() {
            return "Region [nom=" + nom + ", departements=" + departements + "]";
    }

}