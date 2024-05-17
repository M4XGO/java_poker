package fr.esgi.poker.buisness;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Departement implements Comparable<Departement> {

    // Attributs
    private String code;
    private String nom;
    // <> : diamant
    private ArrayList<Ville> villes = new ArrayList<>();
    private Region region;

    // Le constructeur
    public Departement(String code, String nom, Region region) {
        this.code = code;
        this.nom = nom;
        this.region = region;
        // On ajoute l'objet en cours de création à la liste des départements
        // de la région donnée en paramètre
        region.getDepartements().add(this);
    }

    // Getters / Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(ArrayList<Ville> villes) {
        this.villes = villes;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getNbJoueurs() {
        // On parcourt les villes du département
        int total = 0;
        for (Ville ville : villes) {
            total += ville.getJoueurs().size();
        }
        return total;
    }

    // Les méthodes hashCode et equals
    @Override
    public int hashCode() {
        return Objects.hash(code, nom, region);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Departement other = (Departement) obj;
        return Objects.equals(code, other.code) && Objects.equals(nom, other.nom)
                && Objects.equals(region, other.region);
    }

    @Override
    public int compareTo(Departement autreDepartement) {
        return -Integer.valueOf(villes.size()).compareTo(autreDepartement.getVilles().size());
    }

    @Override
    public String toString() {
        return "Departement [code=" + code + ", nom=" + nom + ", villes=" + villes + ", region=" + region.getNom()
                + "]";
    }

}