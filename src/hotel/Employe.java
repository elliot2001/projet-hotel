package hotel;

import java.util.ArrayList;

public class Employe extends Personne {

	private int id;
	private static int nextId;
	private String login;
	private String mdp;

	public Employe() {
		id = nextId;
		nextId++;
	}

	public Employe(String nom, String sexe, int age, String login, String mdp) {
		super(nom, sexe, age);
		this.login = login;
		this.mdp = mdp;
		Hotel.getEmployes().add(this);
	}
	
	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getMdp() {
		return mdp;
	}
	
	
}
