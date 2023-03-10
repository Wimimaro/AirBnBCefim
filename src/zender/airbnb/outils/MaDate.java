package zender.airbnb.outils;

import java.util.Date;

public class MaDate extends Date {

    /**
     *
     * @param jour entre 1 et 31, ie. 1 pour le premier
     * @param mois entre 1 et 12, ie. 1 pour janvier
     * @param annee ie. 2022
     */
    public MaDate(int jour, int mois, int annee){
        super(annee - 1900, mois - 1, jour);
    }

    public MaDate(){
        super();
    }


    public MaDate(long timestamp){
        super(timestamp);
    }

    @Override
    public String toString() {
        return (this.getDate() < 10? "0" : "") + this.getDate()+ "/" +(this.getMonth() <10? "0": "") +
                (this.getMonth() + 1) + "/" + (this.getYear() + 1900);
    }
}
