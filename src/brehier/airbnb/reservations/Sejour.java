package brehier.airbnb.reservations;

import brehier.airbnb.logement.Logement;

import java.util.Date;

public class Sejour {

    //Attributs
    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;

    //Constructeur
    public Sejour(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int paramNbVoyageurs){
        dateArrivee = paramDateArrivee;
        nbNuits = paramNbNuits;
        logement = paramLogement;
        nbVoyageurs = paramNbVoyageurs;
    }

    //Méthode
    public void afficher(){
        logement.afficher();
        System.out.println("\nLa date d'arrivée est le " + dateArrivee + " pour " + nbNuits + " nuits.");
        System.out.print("Le prix de ce séjour est de " + nbNuits * logement.getTarifParNuit() + " €.");
    }
}
