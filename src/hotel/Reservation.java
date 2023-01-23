package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class Reservation {

	private int id;
	private int nextId;
	private Client client;
	private Chambre chambre;
	private int duree;
	private double prixTotal;
	static ArrayList<Reservation>listeResa;
	private LocalDate dateArriver;
	private LocalDate dateDepart;
	
	public Reservation(Client client, Chambre chambre, int duree, ArrayList<Personne> liste, LocalDate dateArriver, LocalDate dateDepart) {
		int i = 0;
		
		id = nextId;
		nextId++;
		this.client = client;
		this.chambre = chambre;
		this.duree = duree;
		i = chambre.getType() == 0 ? 20 : i;
		i = chambre.getType() == 1 ? 40 : i;
		i = chambre.getType() == 2 ? 35 : i;
		i = chambre.getType() == 3 ? 100 : i;
 		this.prixTotal = duree * i;
 		chambre.setPersonnes(liste);
 		chambre.setStatut(1);
 		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
