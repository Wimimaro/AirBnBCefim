package zender.airbnb.reservations;

import zender.airbnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour {

    private static final int PROMOTION_EN_POURCENTAGE = 20;

    private int promotion;

    SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return getNbNuits() > 5 && getNbNuits() <= 31;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Séjour long prix : " + tarif + "€ dont " +promotion + "€ de promo." );
    }

    @Override
    public void miseAJourDuTarif() {
        int tarifInitial = getNbNuits() * getLogement().getTarifParNuit();
        promotion = tarifInitial * PROMOTION_EN_POURCENTAGE / 100;
        tarif = tarifInitial - promotion;
    }
}
