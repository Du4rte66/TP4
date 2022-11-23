package personnages;

public class Humain {
	protected String nom;
	private String boisson;
	protected int argent;
	private Humain[] memoire = new Humain[30];
	private int nbConnaissance = 0;
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}
		
	protected String getNom() {
		return this.nom;
	}

	protected String getBoisson() {
		return this.boisson;
	}

	protected int getArgent() {
		return this.argent;
	}
	
	protected void gagnerArgent(int somme) {
		this.argent += somme;
	}
	
	protected void perdreArgent(int somme) {
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
	
	private void memoriser(Humain autreHumain) {
		if (nbConnaissance >= 30) {
			//supprime la plus vieille connaissance
			for(int i = 0; i < 29; i++) {
				this.memoire[i] = this.memoire[i+1];
			}
			this.nbConnaissance--;
		}
		this.memoire[nbConnaissance] = autreHumain;
		this.nbConnaissance++;
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		this.direBonjour();
		autreHumain.direBonjour();
		this.memoriser(autreHumain);
		autreHumain.memoriser(this);
	}
	
	public void listerConnaissance() {
		if (this.nbConnaissance > 0) {
			StringBuilder bld = new StringBuilder();
			bld.append("Je connais beaucoup de monde dont : " + this.memoire[0].getNom());
			for(int i = 1; i < this.nbConnaissance; i++) {
				bld.append( ", " + this.memoire[i].getNom());
			}
			bld.append(".");
			String texte = bld.toString();
			this.parler(texte);
		}
		else {
			this.parler("Je ne connais personne :(");
		}
	}
}