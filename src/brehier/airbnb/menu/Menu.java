package brehier.airbnb.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import brehier.airbnb.logement.Appartement;
import brehier.airbnb.logement.Logement;
import brehier.airbnb.logement.Maison;
import brehier.airbnb.outils.LireFichierXML;
import brehier.airbnb.reservations.Reservation;
import brehier.airbnb.utilisateurs.Hote;
import brehier.airbnb.utilisateurs.Voyageur;

public class Menu {

	static Scanner scanner;

	static ArrayList<Hote> listHotes;
	static ArrayList<Logement> listLogements;
	static ArrayList<Voyageur> listVoyageurs;
	static ArrayList<Reservation> listReservations;

	public static void main(String[] args) {

		System.out.println("Bienvenue chez AirBnB");

		scanner = new Scanner(System.in);
	
		init();

		listerMenu();

		scanner.close();
	}

	static void listerMenu() {

		System.out.println("-------------------------------------");
		System.out.println("Saisir une option : ");
		System.out.println("1 : Liste des hôtes");
		System.out.println("2 : Liste des logements");
		System.out.println("3 : Liste des voyageurs");
		System.out.println("4 : Liste des réservations");
		System.out.println("5 : Fermer le programme");

		switch (choix(5)) {
		case 1:
			GestionHotes.listerHotes();
			break;
		case 2:
			//GestionLogements.listerLogements();
			break;
		case 3:
			//GestionVoyageurs.listerVoyageurs();
			break;
		case 4:
			//GestionReservations.listerReservations();
			break;
		case 5:
			System.out.println("A bientôt");
			break;
		}
	}

	static int choix(int maxValue) {
		// TODO Ne pas faire planter cette méthode choix !!!!
		int choixUtilisateur = 0;

		while (choixUtilisateur < 1 || choixUtilisateur > maxValue){
			System.out.println("Veuillez rentrer un chiffre entre 1 et " + maxValue);
			try{
				choixUtilisateur = scanner.nextInt();
			} catch (InputMismatchException e){
				System.out.println("Erreur : " + e.getMessage());
				//Sert à vider le buffer du scanner pour éviter une boucle infinie
				String str = scanner.next();
				System.out.println("Attention, la valeur " + str + " n'est pas un chiffre");
			}
		}
		return choixUtilisateur;
	}


	private static void init() {

		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		listVoyageurs = new ArrayList<>();
		listReservations = new ArrayList<>();


		// Création des Hotes
//		Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
//		Hote hote2 = new Hote("Patrick", "Martin", 32, 12);
//		Hote hote3 = new Hote("Jeanne", "Voisin", 26, 24);
//		Hote hote4 = new Hote("Maurice", "Meunier", 46, 12);
//
//		listHotes.add(hote1);
//		listHotes.add(hote2);
//		listHotes.add(hote3);
//		listHotes.add(hote4);

		//Récupération des hôtes depuis le fichier XML
//		for (Hote hote : LireFichierXML.main(characters)) {
//			listHotes.add(hote);
//		}





		// Création de Logement
//		Maison maison1 = new Maison(hote1, 40, "18 rue De Tours, 37000 Tours", 140, 2, 500, true);
//		Maison maison2 = new Maison(hote1, 35, "146 Rue George Sand, 59553 Cuincy", 120, 2, 200, false);
//		Maison maison3 = new Maison(hote1, 60, "13 Rue de la Liberté, 62800 Liévin", 90, 4, 2000, true);
//		Appartement appartement1 = new Appartement(hote1, 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20);
//		Appartement appartement2 = new Appartement(hote1, 35, "111 Rue Colbert, 37000 Tours", 42, 2, 2, 0);
//
//		listLogements.add(maison1);
//		listLogements.add(maison2);
//		listLogements.add(maison3);
//		listLogements.add(appartement1);
//		listLogements.add(appartement2);


		//Récupération des logements depuis le fichier XML
//		for (Logement logement : LireFichierXML.main(characters)) {
//			listLogements.add(logement);
//		}




		// Création de voyageurs
		Voyageur voyageur1 = new Voyageur("Alain", "Favre", 54);
		Voyageur voyageur2 = new Voyageur("Maxime", "Albert", 29);

		listVoyageurs.add(voyageur1);
		listVoyageurs.add(voyageur2);
	}

}