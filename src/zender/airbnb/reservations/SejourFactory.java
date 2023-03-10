package zender.airbnb.reservations;

import zender.airbnb.logements.Logement;

import java.util.Date;

public final class SejourFactory {

    private SejourFactory() {
        
    }

    public static Sejour createSejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        Sejour sejour;
        if (nbNuits <= 5) {
            // Séjour court
            sejour = new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs);
        } else {
            // Séjour long
            sejour = new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
        }
        return sejour;
    }
}
