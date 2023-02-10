package brehier.airbnb.reservations;

import java.util.Date;

public interface SejourInterface {

    //Méthodes
    boolean verificationDateArrivee();
    boolean verificationNombreDeNuits();
    boolean verificationNombreDeVoyageurs();
    void afficher();
}
