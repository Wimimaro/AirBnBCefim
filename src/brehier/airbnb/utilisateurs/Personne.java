package brehier.airbnb.utilisateurs;

public class Personne {

    //Attributs
    private String prenom;
    private String nom;
    private int age;

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
}
