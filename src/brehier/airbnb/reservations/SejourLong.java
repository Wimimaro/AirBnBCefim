package brehier.airbnb.reservations;

import brehier.airbnb.logement.Logement;

import java.util.Date;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface{

    public final static int PROMOTION_EN_POURCENTAGE = 20;
    public int promotion;
    //public int tarif;


    public SejourLong(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int paramNbVoyageurs) {
        super(paramDateArrivee, paramNbNuits, paramLogement, paramNbVoyageurs);
//        int tarifDeBase = nbNuits * logement.getTarifParNuit();
//        this.promotion = (tarifDeBase * PROMOTION_EN_POURCENTAGE / 100);
//        this.tarif = tarifDeBase - promotion;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Il s'agit d'un séjour long avec promotion de " + PROMOTION_EN_POURCENTAGE + "%");
        System.out.println("Le prix final est de " + tarif + "€");
        System.out.println("La promotion est de " + promotion + "€");
        System.out.println(verificationNombreDeNuits() ? "Le nombre de nuits est valide" : "le nombre de nuits n'est pas valide ta mère la moldue");
    }

    @Override
    public boolean beneficiePromotion() {
        return true;
    }

    @Override
    public int getTarif() {
        return tarif;
    }

    @Override
    public boolean verificationNombreDeNuits() {
        //return super.verificationNombreDeNuits(nbNuits);
        return nbNuits >= 6 && nbNuits <= 31;
    }

    @Override
    public void miseAJourDuTarif() {
        int tarifDeBase = nbNuits * logement.getTarifParNuit();
        this.promotion = (tarifDeBase * PROMOTION_EN_POURCENTAGE / 100);
        this.tarif = tarifDeBase - promotion;
    }
}
