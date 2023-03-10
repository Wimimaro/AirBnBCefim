package zender.airbnb.logements;

import zender.airbnb.utilisateurs.Hote;
import zender.airbnb.utilisateurs.Personne;

import java.util.Objects;


public abstract class Logement extends Object implements Comparable<Logement> {

    private final String name;
    private final Hote hote;
    private final int tarifParNuit;
    private final String adresse;
    private final int superficie;
    private final int nbVoyageursMax;

    public Logement(String name, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        super();
        this.name = name;
        this.hote = hote;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public int getSuperficie() {
        return superficie;
    }

    public Hote getHote() {
        return hote;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public int getNbVoyageursMax() {
        return nbVoyageursMax;
    }

    public abstract int getSuperficeTotale();

    public abstract void afficher();


    /**
     *
     *
     *
     * @param logementToCompare
     * @return
     */
    @Override
    public int compareTo(Logement logementToCompare) {

        if (this.tarifParNuit > logementToCompare.tarifParNuit)
            return 1;
        else if (this.tarifParNuit < logementToCompare.tarifParNuit)
            return -1;
        else
            return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tarifParNuit);
    }
}
