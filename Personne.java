package up.mi.jgm.Partie1;
import java.util.List ;
import java.util.ArrayList ;


public class Personne {
	
	//Attributs
	private String nom;
	private int[] preferences; //les chambres sont représentées par leur numéro
	private List<Personne> ennemis;
	private int chambre;
	
	//Constructeur
	public Personne(String nom, int n) {
		this.nom=nom;
		preferences = new int[n];
		ennemis = new ArrayList<Personne>();
	}
	
	//Méthodes
	public String getNom() {
		return nom;
	}
	
	public int getPreference(int a) {
		return preferences[a];
	}
	
	public void ajouterEnnemi(Personne p) {
		if(p!=this && !ennemis.contains(p)) {
			ennemis.add(p);
		}
	}
	
	public void setChambre(int num) {
		chambre=num;
	}
	
	public int getChambre() {
		return chambre;
	}
	
	public List<Personne> getEnnemis(){
		return ennemis;
	}
	
	public int getChambreEnnemi(int a) {
		return ennemis.get(a).getChambre();
	}
	
	public void setPreferences(int[] ordre) {
		preferences = ordre;
	}

	public boolean aDesPreferences() {
		return preferences[0] != 0;
	}
	
	public int rangChambre(int chambre) {
		for(int i=0;i<preferences.length;i++) {
			if(preferences[i]==chambre) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean estJalouse() {
		for(Personne p : ennemis) {
			if(rangChambre(p.getChambre())<rangChambre(chambre)) {
				return true;
			}
		}
		return false;
	}
	
}
