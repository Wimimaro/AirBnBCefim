package zender.airbnb.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import zender.airbnb.utilisateurs.Hote;

class GestionHotes {

	static void listerHotes() {

		System.out.println("-------------------------------------");
		System.out.println("Liste des hôtes ");
	
		// Afficher la liste des hôtes
		for (int i = 0; i < Menu.listHotes.size(); i++) {
			Hote hote = Menu.listHotes.get(i);
			hote.afficher();
		}

		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un hôte");
		System.out.println("2 : Supprimer un hôte");
		System.out.println("3 : Retour");

		switch (Menu.choix(3)) {
			case 1:
				try {
					ajouterHote();
				} catch (Exception e) {
					System.out.println("Une erreur est survenue");
					Menu.scanner.next();
					listerHotes();
				}
				break;
			case 2:
				try {
					supprimerHote();
				} catch (InputMismatchException e) {
					System.out.println("Une erreur est survenue lors de la saisie de l'index");
					Menu.scanner.next();
					listerHotes();
				} catch (IndexOutOfBoundsException e){
					System.out.println("Une erreur est survenue t'es pas dans les bornes");
					listerHotes();
				}
				break;
			case 3:
				Menu.listerMenu();
				break;
		}		
	}

	private static void ajouterHote() throws Exception {

		System.out.println("-------------------------------------");
		System.out.println("Ajouter un nouvel hôte");

		System.out.println("Prénom :");
		String prenom = Menu.scanner.next();
		System.out.println("Nom :");
		String nom = Menu.scanner.next();
		System.out.println("Age :");
		int age = Menu.scanner.nextInt();
		System.out.println("Délai :");
		int delai = Menu.scanner.nextInt();

		Hote hote = new Hote(prenom, nom , age, delai);

		hote.afficher();

		Menu.listHotes.add(hote);

		listerHotes();
	}

	/**
	 *
	 * @throws InputMismatchException
	 * @throws IndexOutOfBoundsException
	 */
	private static void supprimerHote() throws InputMismatchException, IndexOutOfBoundsException {

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un hôte");

		System.out.println("Elément à supprimer :");
		int indexToRemove = Menu.scanner.nextInt();
		Menu.listHotes.remove(indexToRemove);

		listerHotes();
	}
}
