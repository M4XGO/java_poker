package fr.esgi.poker.buisness;

import java.util.ArrayList;
import java.util.List;

public class Region {

    private String nom;
    private List<Departement> departements = new ArrayList<>();

// Deux constructeurs sont dispo : on parle de surcharge de constructeurs
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

    

}
