package fr.esgi.poker.buisness;

import java.util.LinkedList;
import java.util.List;

public class Departement {

    // Attributs
    private String code;
    private String nom;
    private List<Ville> villes = new LinkedList<>();
    private Region region;


    // Constructeurs
    public Departement(String code, String nom, List<Ville> villes, Region region) {
        this.code = code;
        this.nom = nom;
        this.villes = villes;
        this.region = region;
    }


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


    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }


    public Region getRegion() {
        return region;
    }


    public void setRegion(Region region) {
        this.region = region;
    }

    
}
