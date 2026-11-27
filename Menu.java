package up.mi.jgm.Partie1;

import java.util.Scanner;

public class Menu {
	
	//Attributs
	private Groupe groupe;
	private Affectation affectation;
	
	//Constructeur
	public Menu(Groupe groupe) {
		this.groupe=groupe;
		affectation=new Affectation(groupe);
	}
	
	//Méthodes
	
	public void afficherMenu1(Scanner sc) {
		int choix=0;
		while(choix!=3) {
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1. Ajouter une relation entre deux personnes");
			System.out.println("2. Ajouter les préférences d'une personne");
			System.out.println("3. Fin");
			System.out.println("Votre réponse : ");
			choix=Integer.parseInt(sc.nextLine());
			switch(choix) {
			case 1 :
				Personne a,b;
				String nom;
				System.out.print("Entrez le nom de la première personne : ");
				nom=sc.nextLine();
				a=groupe.recherchePersonne(nom);
				System.out.print("Entrez le nom de la deuxième personne (qu'elle déteste) : ");
				nom=sc.nextLine();
				b=groupe.recherchePersonne(nom);
				if(a!=null && b!=null) {
					groupe.ajouterRelation(a, b);
				}
				break;
			case 2:
				affectation.saisirPreferences(sc);
				break;
			case 3 : 
				String manquants = groupe.personnesSansPreferences();
				if (!manquants.isEmpty()) {
					System.out.println("Préférences absentes ou incomplètes pour : " + manquants);
					choix = 0; // on reste dans le menu
				}
				break;
			default :
				System.out.println("Le numéro entré ne correspond pas au menu");
				
			}
		}
			
	}
	
	public void afficherMenu2(Scanner sc) {
		int choix=0;
		affectation.affectationNaive();
		groupe.afficherAffectations();
		while(choix!=3) {
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1. Échanger les chambres de deux personnes");
			System.out.println("2. Afficher le nombre de personnes jalouses");
			System.out.println("3. Fin");
			System.out.println("Votre réponse : ");
			choix=Integer.parseInt(sc.nextLine());
			switch(choix) {
			case 1 :
				affectation.echangerChambre(sc);
				break;
			case 2 :
				System.out.println("Il y a "+ groupe.nombreJalouses() + " personnes jalouses");
				break;
			case 3 :
				break;
			default :
				System.out.println("Le numéro entré ne correspond pas au menu");
				
			}
			groupe.afficherAffectations();
		}
			
	}
}
