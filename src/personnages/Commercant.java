package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer() {
		super.perdreArgent(this.argent);
		this.parler("J'ai tout perdu ! Le monde est trop injuste...");
		return this.argent;
	}
	
	public void recevoir(int argent) {
		this.parler(argent + " sous ! Je te remercie généreux donateur !");
		gagnerArgent(argent);
	}
}
