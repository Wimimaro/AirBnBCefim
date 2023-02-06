package brehier.airbnb;

import brehier.airbnb.logement.Logement;
import brehier.airbnb.utilisateurs.Personne;
import brehier.airbnb.reservations.Sejour;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Personne maPersonne1 = new Personne("Willou ", "LaCartouche ", 30);
        Personne maPersonne2 = new Personne("Jean ", "LaPomme ", 40);

        Logement monLogement1 = new Logement(maPersonne2, 50, "1 rue de la paix, 37000 Tours", 140, 2);

        Date maDate1 = new Date(123, 05, 11);
        Sejour monSejour1 = new Sejour(maDate1, 4, monLogement1, 2);

        //maPersonne1.afficher();
        //monLogement1.afficher();
        monSejour1.afficher();
    }
}
