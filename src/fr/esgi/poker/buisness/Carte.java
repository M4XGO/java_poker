package fr.esgi.poker.buisness;

import javax.xml.validation.Validator;

public class Carte {
    
    private String nom; 
    private int valeur;
    private Couleur couleur;

    
    public Carte(int valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
        switch (valeur) {
            case 14:
                nom = "As";
                break;
            case 13: 
                nom = "Roi";
                break;
            case 12: 
                nom = "Dame";
                break;
            case 11: 
                nom = "Valet";
                break;
            default:
                nom = String.valueOf(valeur);
                break;
            
        }
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getValeur() {
        return valeur;
    }


    public void setValeur(int valeur) {
        this.valeur = valeur;
    }


    @Override
    public String toString() {
        return nom + " de " + couleur;
    }


}
