package brehier.airbnb.reservations;

import brehier.airbnb.utilisateurs.Personne;
import brehier.airbnb.utilisateurs.Voyageur;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

public class Reservation {
    //Attributs

    private static int compteurReservation = 1;
    private int identifiant;
    private Sejour sejour;
    //private Personne personne;

    private Voyageur voyageur;
    private boolean estValidee;
    private Date dateDeReservation;


    //Constructeur
    public Reservation (Sejour paramSejour, Voyageur paramVoyageur) throws Exception{

//        if(!paramSejour.verificationNombreDeNuits(paramSejour.getNbNuits())) {
//            throw new Exception("Le nombre de nuits n'est pas valide");
//        }

        if(paramSejour.verificationNombreDeVoyageurs() && paramSejour.verificationNombreDeNuits() && paramSejour.verificationDateArrivee()) {
            sejour = paramSejour;
            identifiant = compteurReservation;

            voyageur = paramVoyageur;
            estValidee = false;
            dateDeReservation = new Date();

            compteurReservation++;
        } else if(!paramSejour.verificationNombreDeNuits()) {
            throw new Exception("Le nombre de nuits n'est pas valide");
        } else if (!paramSejour.verificationNombreDeVoyageurs()) {
            throw new Exception("Le nombre de voyageurs n'est pas valide");
        } else if (!paramSejour.verificationDateArrivee()) {
            throw new Exception("La date d'arrivée n'est pas valide");
        }


    }

    //Méthode
    public void afficher() {
        voyageur.afficher();
        System.out.println("identifiant : " + identifiant);
        System.out.print(" a fait une réservation chez ");
        sejour.afficher();
    }

//    PrintWriter writer = new PrintWriter(new File("C:\\Users\\brehier\\Documents\\AirBnB\\src\\brehier\\airbnb\\reservations\\Reservation.txt", "UTF-8"));
//    writer.println("identifiant : " + identifiant);
}
