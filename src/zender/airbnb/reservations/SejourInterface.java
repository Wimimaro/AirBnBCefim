package zender.airbnb.reservations;

public interface SejourInterface {

    boolean verificationDateArrivee();

    boolean verificationNombreDeNuits();

    boolean verificationNombreDeVoyageurs();

    void afficher();
}
