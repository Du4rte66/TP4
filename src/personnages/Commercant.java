package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		super(nom, "th�", argent);
	}
	
	public int seFaireExtorquer() {
		int vol = this.argent;
		super.perdreArgent(vol);
		this.parler("J'ai tout perdu ! Le monde est trop injuste...");
		return vol;
	}
	
	public void recevoir(int argent) {
		this.parler(argent + " sous ! Je te remercie g�n�reux donateur !");
		this.gagnerArgent(argent);
	}
}
