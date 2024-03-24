package fr.esgi.poker.buisness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Joueur {
    private String nom; 
    private Long id;
    private Float solde;
    private LocalDate dateDeNaissance; 
    private LocalDateTime dateHeureInscription;
    private ArrayList<Carte> mainCarte = new ArrayList<>();
    private static Long compteur = 0L;

    // Overload -> surchage de constructeur

    /** Default constructueur (qui est vide, sans param )
     * 
     */
    public Joueur(){

    }

    /** Constructeur alléger qui ne prends que le nom en param
     * 
     * @param nom
     */
    public Joueur(String nom, Float solde){
        this.nom = nom; 
        this.solde = solde;
    }

    /** Constructeur complet
     * 
     * @param nom
     * @param solde
     * @param dateDeNaissance
     * @param dateHeureInscription
     * @param mainCarte
     */
    
   
    public Joueur(String nom, Float solde, LocalDate dateDeNaissance, LocalDateTime dateHeureInscription) {
        this.nom = nom;
        this.solde = solde;
        this.dateDeNaissance = dateDeNaissance;
        this.dateHeureInscription = dateHeureInscription;

        id = compteur++; 
        
    }

    public ArrayList<Carte> getMainCarte() {
        return mainCarte;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Float getSolde() {
        return solde;
    }
    public void setSolde(Float solde) {
        this.solde = solde;
    }
    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }
    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    public LocalDateTime getDateHeureInscription() {
        return dateHeureInscription;
    }
    public void setDateHeureInscription(LocalDateTime dateHeureInscription) {
        this.dateHeureInscription = dateHeureInscription;
    }



    @Override
    public String toString() {
        return "[nom=" + nom + ", id=" + id + ", solde=" + solde + ", dateDeNaissance=" + dateDeNaissance
                + ", dateHeureInscription=" + dateHeureInscription + "main carte =" + mainCarte + "]";
    } 

}
