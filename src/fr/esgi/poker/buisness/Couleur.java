package fr.esgi.poker.buisness;

public class Couleur {
    // Attribut de la Class = ce qui définit une couleur
    private String nom;
    
    // Constructeur
    // Methode(s) pour construire un object
    public Couleur(String nom) {
        this.nom = nom;
    }

    // Getter and Setters
    // Methode(s) d'accès et de modification 
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }

        
}
