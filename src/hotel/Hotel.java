package hotel;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Hotel {

	private static String nomHotel;
	private static ArrayList<Chambre> chambres;
	private static ArrayList<Reservation> reservations;
	private static ArrayList<Employe> employes;
	
	private static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<Employe> getEmployes() {
		return employes;
	}
	
	public Hotel() {
		System.out.println("Comment s'appelle l'hotel ?");
		nomHotel = sc.nextLine();
	}
	
	public static void afficherHotel() {
		System.out.printf("Nom : %s, Nombre de reservation : %d, nombre d'employés : %d\n", nomHotel, reservations.size(), employes.size());
	}
	
	public static void afficherNbrResa() {
		System.out.printf("Nombre de chambres réservées : %d\n", reservations.size());
	}
	
	public static void afficherNbrLibre() {
		int res = chambres.size() - reservations.size();
		
		System.out.printf("Nombre de chambres libres : %d\n", res);
	}

	public static void printMenu() {
		System.out.println("*********************************");
		System.out.println("1 -- Afficher l'état de l'hotel");
		System.out.println("2 -- Affciher le nombre de chambres reservées de chaque types");
		System.out.println("3 -- Affciher le nombre de chambres disponibles de chaque types");
		System.out.println("4 -- Afficher le numéros de la première chambre vide");
		System.out.println("5 -- Afficher le numéros de la dernière chambre vide");
		System.out.println("6 -- Réserver une chambre");
		System.out.println("7 -- Liberer une chambre");
		System.out.println("0 -- Quitter");
	}
	
	public static void findFrst() {
		String tab[] = {"Simple", "Jumelle", "Double", "Suite"};
		
		for (int a = 0; a < 4; a++) {
			for (Chambre uno : chambres) {
				if (uno.getStatut() == 0 && uno.getType() == a) {
					System.out.printf("La chambre num %d de type %s est disponible\n", uno.getId(), tab[a]);
					break;
				}
			}
		}
	}
	
	public static void findLast() {
		String tab[] = {"Simple", "Jumelle", "Double", "Suite"};
		int lastId = 0;
		
		for (int a = 0; a < 4; a++) {
			for (Chambre uno : chambres) {
				if (uno.getStatut() == 0 && uno.getType() == a) {
					lastId = uno.getId();
				}
			}
			System.out.printf("La chambre num %d de type %s est disponible\n", lastId, tab[a]);
		}
	}
	
	public static Client creerClientResa() {
		String nom = "";
		String email = "";
		String num = "";
		
		System.out.println("A quel nom souahitez vous reservez ?");
		nom = sc.nextLine();
		System.out.println("Renseigner un e-mail :");
		email = sc.nextLine();
		System.out.println("Renseigner un numéro : ");
		num = sc.nextLine();
		return new Client(nom, email, num);
	}
		
	public static int personneInSuite() {
		int user = 0;
	
		while (1 != 2) {
			System.out.println("Combien de personnes seront dans cette chambre :");
			user = sc.nextInt();
			sc.nextLine();
			if (user > 6 || user < 1) {
				System.out.println("Désolé la suite ne peut recevoir que 6 personnes maximum");
			} else {
				return user;
			}
		}
	}
	
	public static int creerResa(int nb, int neg, Client client, int chambreId) {
		ArrayList<Personne> liste = new ArrayList<Personne>();
		Personne tmp;
		int time = 0;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		LocalDate date_entre;
		LocalDate date_sortie;
		LocalDate date_tmp;
		String d1 = "";
		String d2 = "";
		
		nb -= neg;
		System.out.println("Qui sera dans la chambre svp ?");
		for (int a = 0; a < neg; a++) {
			tmp = new Personne();
			System.out.println("Nom : ");
			tmp.setNom(sc.nextLine());
			System.out.println("Sexe : ");
			tmp.setSexe(sc.nextLine());
			System.out.println("Age : ");
			tmp.setAge(sc.nextInt());
			sc.nextLine();
			liste.add(tmp);
		}
		System.out.println("Quel jour débutera votre séjour ? (Année-Moi-Jour)");
		d1 = sc.nextLine();
		date_entre = LocalDate.parse(d1);
		date_tmp = date_entre;
		System.out.println("Quel jour finira votre séjour ? (Année-Moi-Jour)");
		d2 = sc.nextLine();
		date_sortie = LocalDate.parse(d2);
		while (date_tmp.compareTo(date_sortie) < 0) {
			time++;
			date_tmp = date_tmp.plusDays(1);
		}
		reservations.add(new Reservation(client, chambres.get(chambreId), time, liste, date_entre, date_sortie));
		return nb;
	}
	
	public static int[] dispoProposerChambre() {
		int tab[] = {-1, -1, -1, -1};
		int passed = 0;
		
		for (int a = 0; a < 4; a++) {
			for (Chambre uno : chambres) {
				if (uno.getStatut() == 0 && uno.getType() == a && passed == 0) {
					tab[a] = uno.getId();
					passed = 1;
				}
			}
			passed = 0;
		}
		System.out.println("Quelle(s) chambre(s) vous interesserez ?");
		if (tab[0] != -1) {
			System.out.println("1 -- Chambre seul (1 personne / 20$)");
		}
		if (tab[1] != -1) {
			System.out.println("2 -- Chambre jumelle (2 personnes / 40$)");
		}
		if (tab[2] != -1) {
			System.out.println("3 -- Chambre double (2 personnes / 35$)");
		}
		if (tab[3] != -1) {
			System.out.println("4 -- Suite (max 6 persoones / 100$)");
		}
		return tab;
	}
	
	public static int creerPersonnesResa() {
		int nb = 0;
		
		System.out.println("Combien êtes-vous ?");
		nb = sc.nextInt();
		sc.nextLine();
		return nb;
	}
	
	public static void proposerChambres(Client client) {
		int nb = creerPersonnesResa();
		int user = 0;
		int tab[];
		
		while (nb > 0) {
			tab = dispoProposerChambre();
			user = sc.nextInt();
			sc.nextLine();
			if (user == 1 && tab[0] != -1) {
				nb = creerResa(nb, 1, client, tab[0]);
			} else if (user == 2 && tab[1] != -1) {
				nb = creerResa(nb, 2, client, tab[1]);
			} else if (user == 3 && tab[2] != -1) {
				nb = creerResa(nb, 2, client, tab[2]);
			} else if (user == 4 && tab[3] != -1) {
				nb = creerResa(nb, personneInSuite(), client, tab[3]);
			}
		}
	}
	
	public static void reserver() {
		Client client = creerClientResa();
		
		proposerChambres(client);
	}
	
	public static int swichMenu() {
		int i = sc.nextInt();
		
		sc.nextLine();
		switch (i) {
		case 1:
			afficherHotel();
			break;
		case 2:
			System.out.println("regfergerg");
			afficherNbrResa();
			break;
		case 3:
			afficherNbrLibre();
			break;
		case 4:
			findFrst();
			break;
		case 5:
			findLast();
			break;
		case 6:
			if (Login.login(sc, employes)) {
				reserver();
			}
			break;
		case 7:
			if (Login.login(sc, employes)) {
				
			}
			break;
		case 0:
			return 0;
		default:
			break;
		}
		return 1;
	}
	
	public static void menuLoop() {
		int user = 1;
		
		while (user != 0) {
			printMenu();
			user = swichMenu();
		}
		System.out.println("THE END");
	}
	
	public static void creerChambres() {
		System.out.println("Combien de chambres contient l'hôtel ?");
		int nChambres = sc.nextInt();
		for (int i = 0; i < nChambres; i++) {
			int randomType = randomizeType();
			chambres.add(new Chambre(randomType, 0, null));
		}
		return;
	}
	
	private static int randomizeType() {
		Random random = new Random();
		return random.nextInt(4);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hotel hotel = new Hotel();
		
		employes = new ArrayList<Employe>();
		chambres = new ArrayList<Chambre>();
		reservations = new ArrayList<Reservation>();
		
		
		Employe e1 = new Employe("Georges", "Homme", 23, "J35u5Th354v10R", "123456789");
		Employe e2 = new Employe("Betty", "Femme", 37, "Betty_357", "azertyuiop");
		Employe e3 = new Employe("Bob", "Homme", 52, "BobbyLaTerreur", "05121978");
		Employe e4 = new Employe("Bob", "Homme", 52, "test", "test");
		
		creerChambres();
		
		
		menuLoop();
		sc.close();
	}

}
