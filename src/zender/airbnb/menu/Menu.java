package zender.airbnb.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.xml.sax.SAXException;
import zender.airbnb.logements.Appartement;
import zender.airbnb.logements.Logement;
import zender.airbnb.logements.Maison;
import zender.airbnb.outils.Compare;
import zender.airbnb.outils.LogementsSaxParser;
import zender.airbnb.reservations.Reservation;
import zender.airbnb.utilisateurs.Hote;
import zender.airbnb.utilisateurs.Voyageur;

import javax.xml.parsers.ParserConfigurationException;

public class Menu {

	static Scanner scanner;

	static ArrayList<Hote> listHotes;
	static ArrayList<Logement> listLogements;
	static ArrayList<Voyageur> listVoyageurs;
	static ArrayList<Reservation> listReservations;

	public static void main(String[] args) {

		System.out.println("Bienvenu chez AirBnB");

		scanner = new Scanner(System.in);

		init();

		try {
			LogementsSaxParser.parse("logements.xml" , listLogements, listHotes);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2 méthodes et pas de cast
		Maison maison = findMaisonByName("Maison 12345678");
		if (maison !=null)
			maison.afficher();

		Appartement appartement = findAppartementByName("Appartement 1");

		// 1 méthode et de la cast
		Maison maison1 = (Maison) findLogementByName("Maison 1");
		Appartement appartement1 = (Appartement) findLogementByName("Appartement 1");

		// 1 méthode et pas de cast
		Maison maison2 = findLogementByNameWithGenericity("Maison 1");
		Appartement appartement2 = findLogementByNameWithGenericity("Appartement 1");

		Compare<Logement> compareLogement = new Compare<Logement>(listLogements.get(0), listLogements.get(1));
		compareLogement.getHigher().afficher();

		listerMenu();

		scanner.close();
	}

	private static Appartement findAppartementByName(String name) {

		Appartement appartement = null;

		for (int i = 0; i < listLogements.size(); i++) {
			if (listLogements.get(i).getName().equals(name)) {
				appartement = (Appartement)listLogements.get(i);
			}
		}

		return appartement;
	}

	private static Maison findMaisonByName(String name) {

		Maison maison = null;

		for (int i = 0; i < listLogements.size(); i++) {
			if (listLogements.get(i).getName().equals(name)) {
				maison = (Maison)listLogements.get(i);
			}
		}

		return maison;
	}


	private static Logement findLogementByName(String name) {

		Logement logement = null;

		for (int i = 0; i < listLogements.size(); i++) {
			if (listLogements.get(i).getName().equals(name)) {
				logement = listLogements.get(i);
			}
		}

		return logement;
	}

	private static <T extends Logement> T findLogementByNameWithGenericity(String name) {

		T logement = null;

		for (int i = 0; i < listLogements.size(); i++) {
			if (listLogements.get(i).getName().equals(name)) {
				logement = (T) listLogements.get(i);
			}
		}

		return logement;
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

		int choix = 0;

		boolean choixOK = false;

		do {
			System.out.println("Faire un choix entre 1 et " + maxValue);
			try {
				choix = scanner.nextInt();
				if (choix < 1 || choix > maxValue) {
					System.out.println("Choix incorrect");
				} else {
					choixOK = true;
				}
			} catch (InputMismatchException e ) {
				String str = scanner.next();
				System.out.println("Choix incorrect.......... (" + str+")");
			}
		} while (!choixOK);

		return choix;
	}


	private static void init() {

		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		listVoyageurs = new ArrayList<>();
		listReservations = new ArrayList<>();

		// Création des Hotes
		Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
		Hote hote2 = new Hote("Patrick", "Martin", 32, 12);
		Hote hote3 = new Hote("Jeanne", "Voisin", 26, 24);
		Hote hote4 = new Hote("Maurice", "Meunier", 46, 12);

		listHotes.add(hote1);
		listHotes.add(hote2);
		listHotes.add(hote3);
		listHotes.add(hote4);

		// Création de Logement
		Maison maison1 = new Maison("Maison 12", hote1, 40, "18 rue De Tours, 37000 Tours", 140, 2, 500, true);
		Maison maison2 = new Maison("Maison 13", hote1, 35, "146 Rue George Sand, 59553 Cuincy", 120, 2, 200, false);
		Maison maison3 = new Maison("Maison 14", hote1, 60, "13 Rue de la Liberté, 62800 Liévin", 90, 4, 2000, true);
		Appartement appartement1 = new Appartement("Appartement 11", hote1, 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20);
		Appartement appartement2 = new Appartement("Appartement 12", hote1, 35, "111 Rue Colbert, 37000 Tours", 42, 2, 2, 0);

		listLogements.add(maison1);
		listLogements.add(maison2);
		listLogements.add(maison3);
		listLogements.add(appartement1);
		listLogements.add(appartement2);

		// Création de voyageurs
		Voyageur voyageur1 = new Voyageur("Alain", "Favre", 54);
		Voyageur voyageur2 = new Voyageur("Maxime", "Albert", 29);

		listVoyageurs.add(voyageur1);
		listVoyageurs.add(voyageur2);
	}

}
