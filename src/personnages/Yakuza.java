package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}
	
	public String getClan() {
		return this.clan;
	}

	public int getReputation() {
		return this.reputation;
	}
	
	protected void gagner() {
		this.reputation += 1;
	}
	
	protected void perdre() {
		
		this.reputation -= 1;
	}
	
	public void extorquer(Commercant victime) {
		this.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		this.parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int vol = victime.seFaireExtorquer();
		this.gagner();
		this.argent += vol;
		this.parler("J'ai piqué les " + vol + " sous de " + victime.getNom() + " ce qui me fait " + this.argent + " sous dans ma poche. HI ! HI !");
	}

}