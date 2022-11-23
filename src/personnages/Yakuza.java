package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}
	
	protected String getClan() {
		return this.clan;
	}

	protected int getReputation() {
		return this.reputation;
	}
	
	protected void gagner(int gain) {
		this.argent += gain;
		this.reputation += 1;
		this.parler("Ce ronin pensait vraiment battre " + this.nom + " du clan de " + this.clan + " ? Je l'ai d�pouill� de ses " + gain + " sous.");
	}
	
	protected int perdre() {
		int perte = this.argent;
		this.argent = 0;
		this.reputation -= 1;
		this.parler("J'ai perdu mon duel et mes " + perte + " sous, snif... J'ai d�shonor� le clan de " + this.clan + ".");
		return perte;
	}
	
	public void extorquer(Commercant victime) {
		this.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l� ?");
		this.parler(victime.getNom() + ", si tu tiens � la vie donne moi ta bourse !");
		int vol = victime.seFaireExtorquer();
		this.gagner(vol);
		this.argent += vol;
		this.parler("J'ai piqu� les " + vol + " sous de " + victime.getNom() + " ce qui me fait " + this.argent + " sous dans ma poche. HI ! HI !");
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan + "." );
		
	}

}