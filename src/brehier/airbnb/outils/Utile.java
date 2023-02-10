package brehier.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utile {

    //Attributs
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    //Constructeur par défault il est public, on le redéfinit pour ne pas pouvoir le réinstancier ailleurs
    private Utile(){

    }

    //Méthode
    //facilite l'entrée de la date

    /**
     *
     * JavaDoc
     * Methode utile qui permet de créer une date
     *
     * @author Willou
     * @param jour entre 1 et 31
     * @param mois entre 1 et 12 sachant que  est janvier
     * @param annee
     * @return la date
     */
    public static Date createDate(int jour, int mois, int annee){
        Date date = new Date(annee -1900, mois -1, jour);
        return date;
    }

    public static String dateToString2(Date date){
        String jour = (date.getDate() < 10 ? "0" + date.getDate() : "") + date.getDate();
        String mois = (date.getMonth() < 10 ? "0" + date.getMonth() : "") + date.getMonth();
        String annee = "" + (date.getYear() + 1900);

        return jour + "/" + mois + "/" + annee;
    }


    //facilite la lecture de la date
    public static String dateToString(Date date){
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
