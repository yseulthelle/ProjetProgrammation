package up.mi.jgm.Partie1;

import java.util.Scanner;

public class Affectation {
	
	//Attributs
	private Groupe groupe;
	
	
	//Constructeur
	public Affectation(Groupe groupe) {
		this.groupe=groupe;
	}
	
	//Méthodes
	public void affectationNaive() {
		int n = groupe.getTaille();
		boolean[] prise = new boolean[n];
		Personne p;
		for(int i=0;i<n;i++) {
			p=groupe.getPersonne(i);
			for(int j=0;j<n;j++) {
				int c=p.getPreference(j);
				if(!prise[c-1]) {
					p.setChambre(c);
					prise[c-1]=true;
					break;
				}
			}
		}
	}
	
	public void echangerChambre(Scanner sc) {
		Personne a,b;
		String nom;
		System.out.println("Entrez le nom de la première personne");
		nom=sc.nextLine();
		a=groupe.recherchePersonne(nom);
		System.out.println("Entrez le nom de la deuxième personne");
		nom=sc.nextLine();
		b=groupe.recherchePersonne(nom);
		
		if(a==null || b==null) {
			return;
		}
		
		int tmp = a.getChambre();
		a.setChambre(b.getChambre());
		b.setChambre(tmp);
	}
	
	public void saisirPreferences(Scanner sc) {
		System.out.println("Entrez le nom suivi des préférences : ");
		String[] mots = sc.nextLine().trim().split("\\s+");

		Personne p = groupe.recherchePersonne(mots[0]);
		if (p == null) {
			return;
		}
		
		//On vérifie que l'utilisateur a bien donné n chambres
		int n = groupe.getTaille();
		if (mots.length - 1 != n) {
			System.out.println("Il faut donner exactement " + n + " chambres.");
			return;
		}

		//On vérifie que chaque chambre est différente des autres et comprise entre 1 et n
		int[] ordre = new int[n];
		boolean[] vu = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			int c;
			try {
				c = Integer.parseInt(mots[i + 1]);
			} catch (NumberFormatException e) {
				System.out.println("\"" + mots[i + 1] + "\" n'est pas un nombre.");
				return;
			}
			if (c < 1 || c > n) {
				System.out.println("La chambre " + c + " n'existe pas (de 1 à " + n + ").");
				return;
			}
			if (vu[c]) {
				System.out.println("La chambre " + c + " est donnée deux fois.");
				return;
			}
			vu[c] = true;
			ordre[i] = c;
		}

		p.setPreferences(ordre);
	}
	
}
