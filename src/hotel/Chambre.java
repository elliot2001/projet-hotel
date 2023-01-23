package hotel;

import java.util.ArrayList;

public class Chambre {

	private int id;
	static private int nextId;
	private int type;
	private int statut;
	private ArrayList<Personne> personnesInChambre;
	
	
	public Chambre() {
		id = nextId;
		nextId++;
	}

	// Rajouté
	
	//CHAMBRE SIMPLE
	public Chambre(int type, int statut, ArrayList<Personne> personnesInChambre) {
		id = nextId;
		nextId++;
		this.type = type;
		this.statut = statut;
		this.personnesInChambre = personnesInChambre;
	}
	
	/*//CHAMBRE INITILISATION RANDOM
	public Chambre(int type, int statut, ArrayList<Personne> personnes) {
		super();
		this.type = type;
		this.statut = statut;
		this.personnesInChambre = personnes;
	}
	/*/
	
	public void setPersonnes(ArrayList<Personne> personnesInChambre) {
		this.personnesInChambre = personnesInChambre;
	}
	
	public ArrayList<Personne> getPersonnes() {
		return personnesInChambre;
	}
	
	public int getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}
}
