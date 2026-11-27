package up.mi.jgm.Partie1;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("Entrez le nombre de personnes dans le groupe (1 à 26) : ");
			n = Integer.parseInt(sc.nextLine());
		} while (n < 1 || n > 26);

		Groupe groupe = new Groupe(n);
		Menu menu = new Menu(groupe);
		menu.afficherMenu1(sc);
		menu.afficherMenu2(sc);
	}

}
