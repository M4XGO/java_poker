package fr.esgi.poker;

import java.util.*;

import fr.esgi.poker.buisness.Carte;
import fr.esgi.poker.buisness.Couleur;
import fr.esgi.poker.buisness.Joueur;

public class App {
    private static ArrayList<Couleur> couleurs = new ArrayList<>();
    private static ArrayList<Carte> cartes = new ArrayList<>();
    private static ArrayList<Joueur> joueurs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) throws Exception {
        ajouterCouleurs();
        System.out.println(couleurs);
        ajouterCartes();
        System.out.println(cartes);
        ajouterJoueurVersion1();
        ajouterJoueursVersion1();
        System.out.println("Joueur =");
        System.out.println(joueurs);
        System.out.println("On melange les cartes");
        melangerCartes();
        System.out.println(cartes);
        System.out.println("On distribue les cartes");
        distribuerCarte();

        //affichage des mains des joueurs
        for (Joueur joueur : joueurs) {
            System.out.println(joueur.getNom() + " a en main : " + joueur.getMainCarte());
        }
    

    }

    private static void ajouterCouleurs(){
        couleurs.add(new Couleur("Coeur"));
        Couleur couleur2 = new Couleur("Pique");

        //Ajout à la collection de l'objet couleur2
        couleurs.add(couleur2);

        //Ajout des autres couleurs
        couleurs.add(new Couleur("Carreau"));
        couleurs.add(new Couleur("Trèfle"));
    }
    
    private static void ajouterCartes(){
        for (Couleur couleur : couleurs) {        
            for (int i = 2; i < 15; i++) {
                cartes.add(new Carte(i, couleur));
            }
        }

    }

    private static void ajouterJoueurVersion1(){
        String nomJoueur = ""; 
        float soldeJoueur = 50.0f;
        System.out.print("Quel est le nom du joueur ?");
        nomJoueur = scanner.nextLine();
        joueurs.add(new Joueur(nomJoueur, soldeJoueur));
        scanner.close();
    }

    private static void ajouterJoueursVersion1(){
        String[] listNomJoueur = {"Toplu","Romain","Clément","Maxime","Killian"};
        float soldeJoueur = 50.0f;
        for (int i = 0; i < 5; i++) {
            joueurs.add(new Joueur(listNomJoueur[i], soldeJoueur));
        }
    }

    private static void melangerCartes(){
        Collections.shuffle(cartes); 
    }

    private static void distribuerCarte(){
        for (int i = 0; i < 6; i++) {
            for (Joueur joueur : joueurs) {
                joueur.getMainCarte().add(cartes.remove(i));
            }
        }
    }
}
