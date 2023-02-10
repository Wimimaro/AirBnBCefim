package brehier.airbnb.utilisateurs;

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

}
