package personnages;

public class Ronin extends Humain{
	private int honneur = 1;
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int somme = this.argent / 10;
		parler(beneficiaire.getNom() + " prends ces " + somme + " sous.");
		perdreArgent(somme);
		beneficiaire.recevoir(somme);
	}
}
