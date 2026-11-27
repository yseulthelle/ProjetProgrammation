package up.mi.jgm.Partie1;

import java.util.List;
import java.util.ArrayList;

public class Groupe {
	
	//Attributs
	private List<Personne> personnes;
	
	//Consructeur
	public Groupe(int n) {
		personnes = new ArrayList<Personne>();
		for (int i = 0; i < n; i++) {
			personnes.add(new Personne(String.valueOf((char) ('A' + i)), n));
		}
	}
	
	//Méthode
	public void ajouterRelation(Personne a, Personne b) {
		a.ajouterEnnemi(b);
		b.ajouterEnnemi(a);
	}
	
	public Personne recherchePersonne(String nom) {
		for(Personne p : personnes) {
			if(p.getNom().equals(nom)) {
				return p;
			}
		}
		Personne g=null;
		System.out.println("La personne nommée "+nom+" n'a pas été trouvée.");
		return g;
	}
	
	public Personne getPersonne(int a) {
		return personnes.get(a);
	}
	
	public int nombreJalouses() {
		int nb=0;
		for(Personne p : personnes) {
			if(p.estJalouse()) {
				nb++;
			}
		}
		return nb;
	}
	
	public int getTaille() {
		return personnes.size();
	}
	
	public void afficherAffectations() {
		for(Personne p : personnes) {
			System.out.println(p.getNom() + " : " + p.getChambre());
		}
	}
	
	public String personnesSansPreferences() {
		String res = "";
		for (Personne p : personnes) {
			if (!p.aDesPreferences()) {
				res += p.getNom() + " ";
			}
		}
		return res;
	}
	
	
}
