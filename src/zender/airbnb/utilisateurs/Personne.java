package zender.airbnb.utilisateurs;

import java.util.Objects;

public class Personne {

    // Une personne c'est quoi ? -> Attributs membres
    private final String mPrenom;
    private final String mNom;
    private final int mAge;

    // Une personne ça se construit comment ? -> Constructeurs
    public Personne(String pPrenom, String pNom, int pAge) {

        mPrenom = pPrenom;
        mNom = pNom;
        mAge = pAge;
    }

    // Une personne ça fait quoi ? -> Méthodes
    /**
     * méthode qui permet d'afficher en <b>console</b>
     */
    public void afficher() {
        System.out.print(mPrenom + " " + mNom + " (" + mAge + " ans)");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return mAge == personne.mAge && mPrenom.equals(personne.mPrenom) && mNom.equals(personne.mNom);
    }
}
