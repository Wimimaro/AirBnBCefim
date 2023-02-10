package brehier.airbnb.utilisateurs;

public class Hote extends Personne{
    //Attributs spécifiques à hôte
    private int delaiDeReponse;

    //Constructeur
    public Hote(String paramPrenom, String paramNom , int paramAge, int paramDelaiDeReponse){
        super(paramPrenom, paramNom, paramAge);
        delaiDeReponse = paramDelaiDeReponse;
    }

    //Méthode


    @Override
    public void afficher() {
        super.afficher();
        System.out.println("qui s'engage à répondre dans les " + delaiDeReponse + "heures");
    }

    @Override
    public String toString(){
        return "Nom : " + getNom() + " Prénom : " + getPrenom() + " âge : " + getAge() + " qui s'engage à répondre dans les " + delaiDeReponse + "heures";
    }
}
