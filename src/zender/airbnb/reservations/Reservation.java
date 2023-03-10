package zender.airbnb.reservations;

import zender.airbnb.outils.MaDate;
import zender.airbnb.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {

    private int identifiant;
    private Sejour sejour;
    private Voyageur voyageur;
    private boolean estValidee;
    private Date dateDeReservation;

    public Reservation(Sejour sejour, Voyageur voyageur) {




        if (sejour == null) {
            throw new IllegalArgumentException("Sejour null.....");
        }

        if (!sejour.verificationDateArrivee()) {
            throw new IllegalArgumentException("Sejour incorrect date non valide.....");
        }

        if (!sejour.verificationNombreDeVoyageurs()) {
            throw new IllegalArgumentException("Sejour incorrect nb voyageurs non valide.....");
        }

        if (!sejour.verificationNombreDeNuits()) {
            throw new IllegalArgumentException("Sejour incorrect nb nuits non valide.....");
        }

        this.sejour = (Sejour) sejour.clone();
        this.voyageur = voyageur;
        estValidee = false;
        dateDeReservation = new MaDate();
        identifiant = (int) (Math.random() * 123456789);
    }

    public void afficher(){
        voyageur.afficher();
        System.out.println(" a fait une réservation le "+ dateDeReservation +" chez");
        sejour.afficher();
    }

}

