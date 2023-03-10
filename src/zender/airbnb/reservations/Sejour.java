package zender.airbnb.reservations;


import zender.airbnb.logements.Logement;
import zender.airbnb.outils.MaDate;

import java.util.Date;

public abstract class Sejour implements SejourInterface, Cloneable {

    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;
    protected int tarif;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = new MaDate(dateArrivee.getTime());
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;

        miseAJourDuTarif();
    }

    @Override
    public boolean verificationDateArrivee() {
        Date dateActuelle = new Date();
        return dateArrivee.after(dateActuelle);
    }

    @Override
    public boolean verificationNombreDeVoyageurs() {
        return nbVoyageurs > 0 && nbVoyageurs <= logement.getNbVoyageursMax();
    }

    @Override
    public void afficher() {
        logement.afficher();
        System.out.println("Date d'arrivée  : " + dateArrivee);
    }

    public int getNbNuits() {
        return nbNuits;
    }

    public Date getDateArrivee() {
        return new MaDate(dateArrivee.getTime());
    }

    public Logement getLogement() {
        return logement;
    }

    /**
     *
     * @param logement
     * @throws IllegalArgumentException si le logement est null.......}
     */
    public void setLogement(Logement logement) {

        if (logement == null) {
            throw new IllegalArgumentException("le param est null......");
        }
        this.logement = logement;
        miseAJourDuTarif();
    }

    public abstract void miseAJourDuTarif();


    @Override
    protected Object clone() {
        Sejour sejourClone = null;
        try {
            sejourClone = (Sejour) super.clone();

            // On clone les objets mutables !!
            sejourClone.dateArrivee = (Date) this.dateArrivee.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return sejourClone;
    }
}
