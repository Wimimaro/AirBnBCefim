package brehier.airbnb.reservations;

import brehier.airbnb.logement.Logement;
import brehier.airbnb.outils.MaDate;
import brehier.airbnb.outils.Utile;

import java.util.Date;

public abstract class Sejour implements SejourInterface{

    //Attributs
    private Date dateArrivee;
    protected int nbNuits;
    protected Logement logement;
    private int nbVoyageurs;

    protected int tarif;

    //Constructeur
    public Sejour(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int paramNbVoyageurs){
        dateArrivee = paramDateArrivee;
        nbNuits = paramNbNuits;
        logement = paramLogement;
        nbVoyageurs = paramNbVoyageurs;
        this.tarif = nbNuits * logement.getTarifParNuit();
    }

    @Override
    public boolean verificationDateArrivee() {
        Date DateDuJour = new Date();
        return dateArrivee.after(DateDuJour);
    }

    @Override
    public boolean verificationNombreDeVoyageurs() {
        return nbVoyageurs >=1 && nbVoyageurs <= logement.getNbVoyageursMax();
    }



    /**
     * Méthode abstraite qui permet de mettre à jour le tarif du séjour
     */
    public abstract void miseAJourDuTarif() ;

    //Méthode
    public void afficher(){
        logement.afficher();
        //System.out.println("\nLa date d'arrivée est le " + Utile.dateToString(dateArrivee) + " pour " + nbNuits + " nuits.");
        System.out.println("\nLa date d'arrivée est le " + dateArrivee + " pour " + nbNuits + " nuits.");
        System.out.print("Le prix de ce séjour est de " + nbNuits * logement.getTarifParNuit() + " €.");
        //System.out.println(verificationDateArrivee(dateArrivee) ? "La date d'arrivée est valide" : "La date d'arrivée n'est pas valide");
        System.out.println(verificationNombreDeVoyageurs() ? "Le nombre de voyageurs est valide" : "Le nombre de voyageurs n'est pas valide");
        miseAJourDuTarif();
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public int getNbNuits() {
        return nbNuits;
    }

    public int getNbVoyageurs() {
        return nbVoyageurs;
    }

    public String getLogement() {
        return logement.toString();
    }
}
