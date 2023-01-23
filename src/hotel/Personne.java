package hotel;

import java.util.ArrayList;

public class Personne {
	
	private int id;
	private int nextId = 0;
	private String nom;
	private String sexe;
	private int age;
	private static ArrayList<Personne> personnesInHotel;
	
	public static ArrayList<Personne> getPersonnesInHotel() {
		return personnesInHotel;
	}
	
	public Personne() {
		super();
		id = nextId;
		nextId++;
	}
	
	public Personne(String nom, String sexe, int age) {
		super();
		id = nextId;
		nextId++;
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
	}
	
	public static void setPersonnesInHotel(ArrayList<Personne> personnesInHotel) {
		Personne.personnesInHotel = personnesInHotel;
	}
	public int getId() {
		return id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}
	public String getSexe() {
		return sexe;
	}
	public int getAge() {
		return age;
	}
}
