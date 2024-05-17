package fr.esgi.poker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import fr.esgi.poker.buisness.Carte;
import fr.esgi.poker.buisness.Combinaison;
import fr.esgi.poker.buisness.Couleur;
import fr.esgi.poker.buisness.Departement;
import fr.esgi.poker.buisness.Region;
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
    private static ArrayList<Ville> villes = new ArrayList<>();
	// L'ensemble des départements n'autorise pas les doublons
	private static HashSet<Departement> departements = new HashSet<>();
	private static HashSet<Region> regions = new HashSet<>();

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
    	
    	if (!file.exists()) {
			System.out.println("Fichier CSV indisponible");
			System.exit(1);
		}

		// try with resources
    	// Java va fermer la ressource (reader) automatiquement
    	// à la fin du try
        // try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.toURI().toURL().openStream()))) {

		// On lit dans ce fichier CSV
		// objectif : ajouter un objet Ville pour chaque
		// ligne du fichier CSV
		try {
			// déclarer un objet capable de lire
			// dans un fichier texte
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(file.toURI().toURL().openStream()));

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
				// On déclare une région
				// qui n'existe pas encore en mémoire
				Region region = null;

				if (elements.length >= 14) {
					// On instancie la région
					// en appelant le constructeur avec un paramètre
					region = new Region(elements[14]);
					// On ajoute la région à l'ensemble
					// si la région était déjà présente
					// la collection reste inchangée
					regions.add(region);

					// Pour éviter de faire un new (couteux)
					// on utilise une méthode de récupération
					Departement departement = recupererDepartement(elements[11]);

					if (departement==null) {
						// Le departement n'existe pas encore dans le set de departements
						departement = new Departement(elements[11], elements[12], region);
						departements.add(departement);
					}
					ville.setDepartement(departement);
					// Avec la ligne ci-dessous le département
					// accueille dans s	a liste de villes la nouvelle
					// ligne
					departement.getVilles().add(ville);
				}

            }
        }
        catch (IOException e) {
        	e.printStackTrace();
        }

		System.out.println("Nombre de villes : " + villes.size());
		System.out.println(villes.get(0).hashCode());
		System.out.println(villes.get(1).hashCode());
		System.out.println("Nombre de départements : " + departements.size());
		System.out.println("Nombre de régions : " + regions.size());
		//System.out.println("Régions : " + regions);
		// Teaser B3
		regions.forEach(r -> System.out.println(r.getNom()));
    }

	private static Departement recupererDepartement(String code) {
		for (Departement departement : departements) {
			if (departement.getCode().equals(code)) {
				return departement;
			}
		}
		return null;
	}

	private static Region recupererRegion(String nom) {
		for (Region region : regions) {
			if (region.getNom().equals(nom)) {
				return region;
			}
		}
		return null;
	}

}

