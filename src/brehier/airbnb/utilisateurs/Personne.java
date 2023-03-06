package brehier.airbnb.utilisateurs;

import java.util.Objects;

public class Personne {

    //Attributs
    private String prenom;
    private String nom;
    private int age;

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    //Constructeur
    public Personne(String paramPrenom, String paramNom , int paramAge){
        prenom = paramPrenom;
        nom = paramNom;
        age = paramAge;
    }


    //Méthode
    public void afficher(){
        System.out.print(prenom + nom + "(" + age + " ans)");
    }

    @Override
    public boolean equals(Object o) {
        //this = hote1 , o = hote2
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Personne personne = (Personne) o;

        return age == personne.age && Objects.equals(prenom, personne.prenom) && Objects.equals(nom, personne.nom);
    }
}
