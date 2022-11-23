package personnages;

public class Ronin extends Humain{
	private int honneur = 1;
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int somme = this.argent / 10;
		this.parler(beneficiaire.getNom() + " prends ces " + somme + " sous.");
		this.perdreArgent(somme);
		beneficiaire.recevoir(somme);
	}
	
	private void gagner() {
		this.honneur += 1;
	}
	
	private void perdre() {
		this.honneur -= 1;
	}
	
	public void provoquer(Yakuza adversaire) {
		if ((honneur*2) >= adversaire.getReputation()) {
			this.gagner();
			this.parler("Je t'ai retrouvé vermine, tu as payer pour ce que tu as fait à ce pauvre marchand !");
			this.parler("Je t'ai eu petit yakuza !");
			this.argent = adversaire.perdre();
		}
		else {
			this.perdre();
			this.parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			adversaire.gagner(this.argent);
			this.argent = 0;
		}
	}
}
