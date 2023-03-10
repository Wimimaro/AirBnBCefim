package zender.airbnb.reservations;

import zender.airbnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour {

    SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    @Override
    public boolean verificationNombreDeNuits() {
        if (getNbNuits() > 0 && getNbNuits() <= 5) {
            return true;
        }
        return false;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Séjour court prix : " + tarif + "€");
    }

    @Override
   public void miseAJourDuTarif() {
        this.tarif = getNbNuits() * getLogement().getTarifParNuit();
    }
}
