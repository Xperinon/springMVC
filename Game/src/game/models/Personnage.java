package game.models;

public abstract class Personnage {


	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
	
	private int taille;
	private String pseudo;
	private int poids;
	private Inventaire inventaire;
	private Equipement equipements;
	private Deplacement deplacement;
	
	
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	public Equipement getEquipements() {
		return equipements;
	}
	public void setEquipements(Equipement equipements) {
		this.equipements = equipements;
	}
	public Deplacement getDeplacement() {
		return deplacement;
	}
	public void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
	}
	
}
