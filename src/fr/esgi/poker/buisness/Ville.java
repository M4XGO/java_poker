package fr.esgi.poker.buisness;

public class Ville {
    private Long id; 
    private String nom;
    private String codePostal;
    private String codeInsee;
    private double latitude;
    private double longitude;

    public Ville() {
    }

    public Ville(String nom, String codePostal, String codeInsee, double latitude, double longitude) {
        this.nom = nom;
        this.codePostal = codePostal;
        this.codeInsee = codeInsee;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getCodeInsee() {
        return codeInsee;
    }
    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
}
