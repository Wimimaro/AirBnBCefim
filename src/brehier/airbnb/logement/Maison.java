package brehier.airbnb.logement;

import brehier.airbnb.menu.Menu;
import brehier.airbnb.utilisateurs.Hote;

public class Maison extends Logement{
    //Attributs spécifiques à Maison
    private int superficieJardin;
    private boolean possedePiscine;

    //Constructeur
    public Maison (String name, Hote paramHote, int paramTarifParNuit, String paramAdresse, int paramSuperficie, int paramNbVoyageursMax, int paramSuperficieJardin, boolean paramPossedePiscine){
        super(name, paramHote, paramTarifParNuit, paramAdresse, paramSuperficie, paramNbVoyageursMax);
        this.superficieJardin = paramSuperficieJardin;
        this.possedePiscine = paramPossedePiscine;
    }

    //Methode

    @Override
//    public void afficher() {
//        super.afficher();
//        System.out.println("Jardin : "+ superficieJardin);
//        System.out.println("Piscine : "+ possedePiscine);
//    }
    public void afficher(){
        super.afficher();
        System.out.println("Le logement est une maison");
        System.out.println("Superficie du jardin : " + superficieJardin + " m²");
        if(possedePiscine){
            System.out.println("La maison possède une piscine.");
        }else{
            System.out.println("La maison ne possède pas de piscine.");
        }
    }

//    public static Maison findMaisonByName(String name){
//        for (Logement logement : Menu.listLogements) {
//            if(logement instanceof Maison){
//                if(logement.getName().equals(name)){
//                    return Maison maison;
//                }
//            }
//        }
//    }
}
