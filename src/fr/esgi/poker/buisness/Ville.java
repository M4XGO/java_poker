package fr.esgi.poker.buisness;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ville {

    // On ne peut pas utiliser le codeInsee comme clé car certaines communes
    // partagent le même code Insee
    private Long id;
    
    private String codeInsee;
    private String nom;
    private String codePostal;
    private double longitude;
    private double latitude;
    private String complement;
    // On déclare une liste de joueurs dans cette classe
    private List<Joueur> joueurs = new ArrayList<>();
    private Departement departement;
    
    private static Long compteur = 0L;
    
    /**
     * Constructeur par défaut (c'est-à-dire sans paramètre)
     */
    public Ville() {
        // D'abord on incrémente le compteur puis on l'affecte à l'attribut id
        id=++compteur;        
    }
    
    /**
     * Constructeur qui prend en paramètre le nom et le code postal
     * @param nom
     * @param codePostal
     */
    public Ville(String nom, String codePostal) {
        // On commence par invoquer le constructeur par défaut
        // on fait cela pour ne pas copier-coller le code présent dans le constructeur par défaut
        // DRY : Don't Repeat Yourself
        // (en Java si vous faites du copier-coller -> à revoir)
        this();
        this.nom = nom;
        this.codePostal = codePostal;
    }
    
    public Ville(String codeInsee, String nom, String codePostal) {
        this(nom, codePostal);
        this.codeInsee = codeInsee;
    }


    public Ville(String codeInsee, String nom, String codePostal, double longitude, double latitude) {
        this(codeInsee, nom, codePostal);
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Long getCompteur() {
        return compteur;
    }

    public static void setCompteur(Long compteur) {
        Ville.compteur = compteur;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Departement getDepartement() {
        return departement;
    }
    
    public String getNomDepartementComplement() {
        return nom + getDepartement() + complement;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

//    // le hascode est comme un code barre
    @Override
    public int hashCode() {
        return Objects.hash(codeInsee, codePostal, complement, id, latitude, longitude, nom);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ville other = (Ville) obj;
        return Objects.equals(codeInsee, other.codeInsee) && Objects.equals(codePostal, other.codePostal)
                && Objects.equals(complement, other.complement) && Objects.equals(id, other.id)
                && Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.latitude)
                && Double.doubleToLongBits(longitude) == Double.doubleToLongBits(other.longitude)
                && Objects.equals(nom, other.nom);
    }

    @Override
    public String toString() {
        return "Ville [id=" + id + ", codeInsee=" + codeInsee + ", nom=" + nom + ", codePostal=" + codePostal
                + ", longitude=" + longitude + ", latitude=" + latitude + ", complement=" + complement + ", joueurs="
                + joueurs + ", departement=" + (departement!=null ? departement.getNom() : "inconnu") + "]";
    }
    
}
