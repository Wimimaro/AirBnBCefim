package brehier.airbnb.reservations;

import brehier.airbnb.logement.Logement;
import brehier.airbnb.outils.MaDate;

import java.util.Date;

public class SejourSpecialSaintValentin extends Sejour implements ConditionsTarifairesInterface{

        public static final int PROMOTION_EN_POURCENTAGE_SV = 10;
        public int promotion;
        public int tarif;

        public SejourSpecialSaintValentin(Logement paramLogement) {
            super(new MaDate(14,2,2023), 2, paramLogement, 2);
        }

        @Override
        public void afficher() {
            super.afficher();
            System.out.println("Il s'agit d'un séjour spécial Saint-Valentin avec promotion dont le tarif est de " + tarif + "€");
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
            return nbNuits == 2;
        }

        @Override
        public void miseAJourDuTarif() {
            int tarifDeBase = nbNuits * logement.getTarifParNuit();
            this.promotion = (tarifDeBase * PROMOTION_EN_POURCENTAGE_SV / 100);
            this.tarif = tarifDeBase - promotion;
        }
}
