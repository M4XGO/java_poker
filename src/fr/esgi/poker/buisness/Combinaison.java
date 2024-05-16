package fr.esgi.poker.buisness;

public class Combinaison {

    public Joueur joueur;

    public enum Combinason {
        CARTE_HAUTE,
        PAIRE,
        DOUBLE_PAIRE,
        BRELAN,
        SUITE,
        COULEUR,
        FULL,
        CARRE,
        QUINTE_FLUSH,
        QUINTE_FLUSH_ROYALE
    }

    public Combinaison(Joueur joueur) {
        this.joueur = joueur;
    }
    
    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    @Override
    public String toString() {
        return "Combinaison [joueur=" + joueur + "]";
    }
    
}
