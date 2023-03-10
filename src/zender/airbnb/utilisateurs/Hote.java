package zender.airbnb.utilisateurs;

import java.util.Objects;

public class Hote extends Personne implements Comparable<Hote> {

    private final int delaiDeReponse;

    public Hote(String pPrenom, String pNom, int pAge, int pDelaiDeReponse) {
        super(pPrenom, pNom, pAge);
        delaiDeReponse = pDelaiDeReponse;
    }

    @Override
    public void afficher() {
        super.afficher();
        if (delaiDeReponse > 1) {
            System.out.println(" qui s'engage à répondre dans les " + delaiDeReponse + " heures.");
        } else {
            System.out.println(" qui s'engage à répondre dans l'heure.");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (o.getClass() != this.getClass())
            return false;

        Hote hote = (Hote) o;

        return super.equals(o) && delaiDeReponse == hote.delaiDeReponse;
    }

    @Override
    public int compareTo(Hote o) {
        return this.delaiDeReponse - o.delaiDeReponse;
    }
}
