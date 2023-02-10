package brehier.airbnb.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import brehier.airbnb.utilisateurs.Hote;

import static brehier.airbnb.menu.Menu.scanner;

class GestionHotes {

	static void listerHotes() {

		System.out.println("-------------------------------------");
		System.out.println("Liste des hôtes ");
		int id = 1;
	
		// Afficher la liste des hôtes
		for (Hote hote : Menu.listHotes) {
			System.out.println("id = " + id + " " + hote);
			id++;
		}

		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un hôte");
		System.out.println("2 : Supprimer un hôte");
		System.out.println("3 : Retour");

		switch (Menu.choix(3)) {
			case 1:
				System.out.println("Ajouter un hôte");
				try {
					ajouterHote();
				} catch (Exception e) {
					e.getMessage();
					System.out.println("Erreur lors de la saisie de l'ajout de l'hôte, " + e.getMessage());
					//On ramène l'user au menu
					listerHotes();
				}
				//ajouterHote();
				break;
			case 2:
				System.out.println("Supprimer un hôte");
				try {
					supprimerHote();
				} catch (Exception e) {
					System.out.println("Erreur lors de la saisie de la suppression de l'hôte");
					listerHotes();
				}
				//supprimerHote();
				break;
			case 3:
				Menu.listerMenu();
				break;
		}		
	}

	private static void ajouterHote() throws Exception{

		System.out.println("-------------------------------------");
		System.out.println("Ajouter un nouvel hôte");

		// TODO, pas de try catch ici, on fait remonter l'erreur pour permettre à l'utilisateur d'avoir le choix dans le menu

			System.out.println("Saisir le prénom: ");
			String prenom = Menu.scanner.next();
			System.out.println("Saisir le nom: ");
			String nom = Menu.scanner.next();
			System.out.println("Saisir l'âge: ");
			int age = Menu.scanner.nextInt();
			System.out.println("Saisir le délai de réponse");
			int delaiDeReponse = scanner.nextInt();

			Menu.listHotes.add(new Hote(prenom, nom, age, delaiDeReponse));

			//System.out.println("Erreur de saisie");

		listerHotes();
	}

	private static void supprimerHote() throws Exception{

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un hôte");

		// TODO
		System.out.println("Saisir l'identifiant de l'hôte à supprimer: ");
		int id = Menu.scanner.nextInt();

		try{
			Menu.listHotes.remove(id-1);
		} catch (IndexOutOfBoundsException e){
			System.out.println("Erreur de saisie, l'identifiant " + id + "n'existe pas");
		}

		listerHotes();
	}
}
