package hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) {

		
	}
	//Swich d'Elliot, rajouté case 6 et 7 (utilisateur)
	
	public static void ajouterEmploye(Employe employe, ArrayList<Employe> employes) {
		employes.add(employe);
	}

	public static boolean login(Scanner sc, ArrayList<Employe> employes) {
		String user;
		String mdp;
		System.out.println("Nom d'utilisateur : ");
		user = sc.nextLine();
		System.out.println("Mot de Passe : ");
		mdp = sc.nextLine();
		for (Employe employe : employes) {
			if (employe.getLogin().equals(user)) {
				if(employe.getMdp().equals(mdp)) {
					System.out.println("Bonjour, " + employe.getNom());
					return true;
					}
			}
		}
		System.out.println("Nom d'utilisateur ou Mot de Passe invalide");
		return false;
	}
}
