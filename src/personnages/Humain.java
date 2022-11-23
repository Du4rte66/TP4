package personnages;

public class Humain {
	private String nom;
	private String boisson;
	protected int argent;
	
	public Humain(String nom, String boisson, int argent) {
		super();
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}
		
	public String getNom() {
		return this.nom;
	}

	public String getBoisson() {
		return this.boisson;
	}
	public void setBoisson(String boisson) {
		this.boisson = boisson;
	}
	public int getArgent() {
		return this.argent;
	}
	
	public void gagnerArgent(float somme) {
		this.argent += somme;
	}
	
	public void perdreArgent(float somme) {
		this.argent -= somme;
	}
	
	public void parler(String texte) {
		System.out.println("(" + this.nom + ") - " + texte);
	}
	
	public void direBonjour() {
		this.parler("Bonjour ! Je m'appelle " + this.nom + " et j'aime boire du " + this.boisson + ".");
	}
		
	public void boire() {
		this.parler("Mmmm, un bon verre de " + this.boisson + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		String texte;
		if (prix < this.argent) {
			texte = "J'ai " + this.argent + " sous en poche. Je vais pouvoir";
			this.perdreArgent(prix);
		}
		else {
			texte = "Je n'ai que " + this.argent + " sous en poche. Je ne peux même pas";
		}
		this.parler(texte + " m'offrir un " + bien + " à " + prix + " sous.");
	}
	
	
}