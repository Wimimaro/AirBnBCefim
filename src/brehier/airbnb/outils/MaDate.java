package brehier.airbnb.outils;

import java.util.Date;

public class MaDate extends Date {

    //Constructeur
    public MaDate(int jour, int mois, int annee){
        super(annee -1900, mois -1, jour);
    }

    //Méthode
    @Override
    public String toString(){
        String jour = (getDate() < 10 ? "0"  : "") + getDate();
        String mois = (getMonth() < 9 ? "0"  : "") + (getMonth() + 1);
        String annee = "" + (getYear() + 1900);

        return jour + "/" + mois + "/" + annee;
    }

}
