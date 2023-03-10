package zender.airbnb.outils;

import zender.airbnb.logements.Appartement;
import zender.airbnb.logements.Logement;
import zender.airbnb.logements.Maison;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Recherche {

    private final int nbVoyageurs;
    private final int tarifMin;
    private final int tarifMax;
    private final int possedePiscine;
    private final int possedeBalcon;

    private Recherche(Builder builder) {
        this.nbVoyageurs = builder.nbVoyageurs;
        this.tarifMin = builder.tarifMin;
        this.tarifMax = builder.tarifMax;
        this.possedePiscine = builder.possedePiscine;
        this.possedeBalcon = builder.possedeBalcon;
    }

    private enum Choix {

        OUI(1),
        NON(2),
        PAS_DIT(3);

        private int value;

        Choix(int value) {
            this.value = value;
        }
    }

    public ArrayList<Logement> result() {
        ArrayList<Logement> logements = AirBnBData.getInstance().getLogements();

        ArrayList<Logement> result = new ArrayList<>();

        for (int i = 0; i < logements.size(); i++) {
            Logement logement = logements.get(i);

            // SI c'est pas bon en terme de voyageurs
            if (logement.getNbVoyageursMax() < nbVoyageurs) {
                continue;
            }

            // Test du tarif par nuit
            if (logement.getTarifParNuit() < tarifMin || logement.getTarifParNuit() > tarifMax)
                continue;

            // Test pour la piscine
            if (possedePiscine == Choix.OUI.value) {
                // Oui pour la piscine du coup c'est forcément une maison
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // La maison n'a pas de piscine, on ne la prend pas
                    if (!maison.hasPiscine())
                        continue;
                } else
                    continue;

            } else if (possedePiscine == Choix.NON.value) {
                // Non pour la piscine
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // Si la maison a une piscine, on ne la prend pas
                    if (maison.hasPiscine())
                        continue;
                }
            }

            // Test pour le balcon
            if (possedeBalcon == Choix.OUI.value) {
                // Oui pour le balcon, c'est forcément un appartement
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement n'a pas de balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() == 0)
                        continue;
                } else
                    continue;
            } else if (possedeBalcon == Choix.NON.value) {
                // Non pour le balcon
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement a pas un balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() != 0)
                        continue;
                }
            }

            result.add(logement);
        }

        return result;
    }

    public List<Logement> result2() {

        return AirBnBData.getInstance().getLogements().stream()
                .filter(predicatNBVoyageur().and(predicatTarif()))
                .filter(predicatBalcon())
                //.sorted(Comparator.comparing(Logement::getTarifParNuit))
                .sorted(Logement::compareTo) // vu que Logement implémente l'interface Comparable, oh yeah!
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Predicate<Logement> predicatNBVoyageur() {
        return logement -> logement.getNbVoyageursMax() >= nbVoyageurs;
    }

    private Predicate<Logement> predicatTarif() {
        return logement -> tarifMin <= logement.getTarifParNuit() && logement.getTarifParNuit() <= tarifMax;
    }

    private Predicate<Logement> predicatPiscine() {

        if (possedePiscine == Choix.OUI.value) {
            return logement -> logement instanceof Maison && ((Maison) logement).hasPiscine();
        } else if (possedePiscine == Choix.NON.value) {
            return logement -> logement instanceof Maison && !((Maison) logement).hasPiscine() || !(logement instanceof Maison);
        } else {
            return logement -> true;
        }
    }

    private Predicate<Logement> predicatBalcon() {

        if (possedeBalcon == Choix.OUI.value) {
            return logement -> logement instanceof Appartement && ((Appartement) logement).getSuperficieBalcon() > 0;
        } else if (possedeBalcon == Choix.NON.value) {
            return logement -> logement instanceof Appartement && ((Appartement) logement).getSuperficieBalcon() == 0
                    || !(logement instanceof Appartement);
        } else {
            return logement -> true;
        }
    }


    public static class Builder {

        private final int nbVoyageurs;
        private int tarifMin;
        private int tarifMax;
        private int possedePiscine;
        private int possedeBalcon;

        public Builder(int nbVoyageurs) {
            this.nbVoyageurs = nbVoyageurs;
            this.possedePiscine = Choix.PAS_DIT.value;
            this.possedeBalcon = Choix.PAS_DIT.value;
            this.tarifMin = 0;
            this.tarifMax = Integer.MAX_VALUE;
        }

        public Builder tarifMin(int tarifMin) {
            this.tarifMin = tarifMin;
            return this;
        }

        public Builder tarifMax(int tarifMax) {
            this.tarifMax = tarifMax;
            return this;
        }

        public Builder possedePiscine(boolean possedePiscine) {

            if (possedePiscine) {
                this.possedePiscine = Choix.OUI.value;
            } else {
                this.possedePiscine = Choix.NON.value;
            }

            return this;
        }

        public Builder possedeBalcon(boolean possedeBalcon) {
            this.possedeBalcon = possedeBalcon ? Choix.OUI.value : Choix.NON.value;
            return this;
        }

        public Recherche build() {
            return new Recherche(this);
        }
    }
}
