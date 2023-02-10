package brehier.airbnb.logement;

import brehier.airbnb.utilisateurs.Hote;
import brehier.airbnb.utilisateurs.Personne;

public abstract class Logement {

    //Attributs
    //private Personne hote;
    private Hote hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;


    //Constructeur
    public Logement(Hote paramHote, int paramTarifParNuit, String paramAdresse, int paramSuperficie, int paramNbVoyageursMax){
        //hote = paramHote;
        hote = paramHote;
        tarifParNuit = paramTarifParNuit;
        adresse = paramAdresse;
        superficie = paramSuperficie;
        nbVoyageursMax = paramNbVoyageursMax;
    }

    //Méthode
    public void afficher(){
        hote.afficher();
        System.out.println("\nLe logement est situé au " + adresse);
        System.out.println("Superficie : " + superficie + " m²");
    }

    //Méthode => Getters + Setters
    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public int getNbVoyageursMax(){
        return nbVoyageursMax;
    }
}
