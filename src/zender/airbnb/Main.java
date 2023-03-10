package zender.airbnb;

import peter.airbnb.logements.Appartement;
import peter.airbnb.logements.Logement;
import peter.airbnb.logements.Maison;
import peter.airbnb.outils.AirBnBData;
import peter.airbnb.outils.MaDate;
import peter.airbnb.outils.Recherche;
import peter.airbnb.reservations.*;
import peter.airbnb.utilisateurs.Hote;
import peter.airbnb.utilisateurs.Voyageur;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        testRecherche();

        Voyageur voyageur = new Voyageur("Peter","Bardu",12);
        Hote hote = new Hote("Paul","Martin", 42, 24);

        Maison maison1 = new Maison("Maison 1", hote, 50, "3 Rue de tours", 100,4, 1000, true);
        Appartement appartement1 = new Appartement("Appartement 1", hote, 150, "12 Rue de tours", 100,4, 12, 3);

        // Critères du séjour
        Date date = new MaDate(12, 2, 2022);
        int nbNuits = 2;
        int nbVoyageurs = 4;
        Logement logement = appartement1;

        // Création du séjour
        Sejour sejour = SejourFactory.createSejour(date, nbNuits,logement,nbVoyageurs);

        try {
            Reservation reservation = new Reservation(sejour, voyageur);
            sejour.setLogement(maison1);
            //reservation.afficher();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static void testRecherche() {
        Recherche recherche = new Recherche.Builder(2)
                .tarifMin(50)
                .tarifMax(100)
                .build();

        ArrayList<Logement> logements = recherche.result();

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Résultat de la recherche");
        for (Logement logement: logements) {
            System.out.println("--------------------------");
            logement.afficher();
        }

        // Ou en faisant référence à une méthode (question 2°)
        //logements.forEach(Logement::afficher);

        // Le prix moyen des logements :
        double moyenne = logements.stream().mapToInt(i -> i.getTarifParNuit()).average().getAsDouble();

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Le prix moyen est : " + moyenne + "€");


        // Le logement le moins cher
        Optional<Logement> optional =logements.stream().findFirst();
        System.out.println("-------------------------------------------------------------------------");
        if (optional.isPresent()) {
            optional.get().afficher();
        } else {
            System.out.println("Pas de résultat");
        }
    }


}
