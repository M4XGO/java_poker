package fr.esgi.poker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import fr.esgi.poker.buisness.Carte;
import fr.esgi.poker.buisness.Combinaison;
import fr.esgi.poker.buisness.Couleur;
import fr.esgi.poker.buisness.Joueur;
import fr.esgi.poker.buisness.Ville;
import fr.esgi.poker.buisness.Combinaison.Combinason;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.File;

public class App {
    private static ArrayList<Couleur> couleurs = new ArrayList<>();
    private static ArrayList<Carte> cartes = new ArrayList<>();
    private static ArrayList<Joueur> joueurs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) throws Exception {
        // ajouterCouleurs();
        // // System.out.println(couleurs);
        // ajouterCartes();
        // // System.out.println(cartes);
        // ajouterJoueurVersion1();
        // ajouterJoueursVersion1();
        // // System.out.println("Joueur =");
        // // System.out.println(joueurs);
        // System.out.println("On melange les cartes");
        // melangerCartes();
        // // System.out.println(cartes);
        // System.out.println("On distribue les cartes");
        // distribuerCarte();

        // //affichage des mains des joueurs
        // for (Joueur joueur : joueurs) {
        //     System.out.println(joueur.getNom() + " a en main : " + joueur.getMainCarte());
        //     System.out.println(analyserMain(joueur));
        // }
        importerDonnees("communes-departement-region.csv");
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
        for (int i = 0; i < 5; i++) {
            for (Joueur joueur : joueurs) {
                joueur.getMainCarte().add(cartes.remove(i));
            }
        }
    }


    private static Combinaison.Combinason analyserMain(Joueur joueur) {
        // Combinaison Combinason = new Combinaison(joueur);
        ArrayList<Carte> carteJoueur = joueur.getMainCarte();
        int totalPointMain = 0; // Initialize the variable with a default value
        List<Integer> valeursCartes = new ArrayList<>();
        List<Couleur> couleursCartes = new ArrayList<>();
        int pair = 0;
        int brellan = 0;
        int carre = 0;
        int couleur = 0;
        // Couleur couleurCartePrecedent = null;
        
        for (Carte carte : carteJoueur) {
            valeursCartes.add(carte.getValeur());
            couleursCartes.add(carte.getCouleur());
        }

        System.out.println(valeursCartes);

        //count the color in the card
        int countTrefle = Collections.frequency(couleursCartes,"Trèfle");
        int countCoeur = Collections.frequency(couleursCartes, "Coeur");
        int countCarreau = Collections.frequency(couleursCartes, "Carreau");
        int countPique = Collections.frequency(couleursCartes, "Pique");
            
        if(countPique == 5 || countCarreau == 5 || countCoeur == 5 || countTrefle == 5){
            couleur += 1; 
        }
        //count each value in the card
        for (int j = 2; j < 15; j++) {
            int countValeur = Collections.frequency(valeursCartes, j);
            System.out.println(countValeur);
            System.out.println(j);

            if(countValeur == 2){
                pair += 1;
            }
            if(countValeur == 3){
                brellan += 1;
            }
            if(countValeur == 4){
                carre += 1; 
            }
        }

        if(pair == 1 && brellan == 1){
            return Combinaison.Combinason.FULL;
        }

        if (pair == 1) {
            return Combinaison.Combinason.PAIRE; 
        }

        if(pair == 2){
            return Combinaison.Combinason.DOUBLE_PAIRE; 
        }

        if(couleur == 1){
            return Combinaison.Combinason.COULEUR; 
        }


        return Combinaison.Combinason.CARTE_HAUTE; 

    }   


    private static void importerDonnees(final String nomFichier) {

        File file = new File(nomFichier);
        ArrayList<Ville> villes = new ArrayList<>();
        
        if (!file.exists()) {
            System.out.println("Fichier CSV indisponible");
            System.exit(1);
        }
        
        // On lit dans ce fichier CSV
        // objectif : ajouter un objet Ville pour chaque
        // ligne du fichier CSV
        try {
            // déclarer un objet capable de lire
            // dans un fichier texte
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.toURI().toURL().openStream())
            );

            System.out.println("ligne d'entête : " + reader.readLine());
            String ligne = null;
            while ((ligne = reader.readLine()) != null) {
                // On charge les différentes parties de la ligne dans un tableau de String
                String[] elements = ligne.split(",");

                Ville ville = new Ville();
                ville.setCodeInsee(elements[0]);
                ville.setNom(elements[1]);
                ville.setCodePostal(elements[2]);
                if (!elements[5].isBlank() && !elements[6].isBlank()) {
                    ville.setLatitude(Double.valueOf(elements[5]));
                    ville.setLongitude(Double.valueOf(elements[6]));                    
                }
                villes.add(ville);
                System.out.println(villes.size());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("read error");
        }
}
}

