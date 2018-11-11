/**
 * 
 * Die Klasse simuliert ein Artikel
 * 
 * @author Guidoux Alexandre && Chopin Johann
 * @version 1.0
 */

public class Artikel {
	private int nummer;
	private String bezeichnung;
	private int bestand;
	
	/**
	 * IllegalArgumentException mit @msg zurückgesendet, wenn die @bedigung falsch ist
	 * @param bedigung  Die Bedigung
	 * @param msg       Die Nachricht der Ausnahme
	 */
	public void check(boolean bedigung, String nachricht) {
		if (!bedigung)
			throw new IllegalArgumentException(nachricht);
	}
	
	/**
	 * @param nummer      Der Nummer muss 4-stellig sein
	 * @param bezeichnung Der Bezeichnung muss nicht leer sein
	 * @param bestand     Der Bestand darf nie kleiner als 0 werden
	 */
	Artikel(int nummer, String bezeichnung, int bestand) {
		check(bezeichnung != null || !bezeichnung.isEmpty(), "Der Bezeichnung muss nicht leer sein");
		check(999 < nummer && nummer < 10000, "Der Nummer muss 4-stellig sein");
		
		this.nummer = nummer;
		this.bezeichnung = bezeichnung;
		setBestand(bestand);
	}
	
	/**
	 * @param nummer      Der Nummer muss 4-stellig sein
	 * @param bezeichnung Der Bezeichnung muss nicht leer sein
	 */
	Artikel(int nummer, String bezeichnung){
		this(nummer, bezeichnung, 0);
	}
	
	
	
	
	public int getNummer() {
		return nummer;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public int getBestand() {
		return bestand;
	}

	
	
	
	/**
	 * @param bestand muss immer >= 0 sein
	 */
	public void setBestand(int bestand) {
		check(bestand >= 0, "Der Bestand darf nicht < 0 werden.");
		this.bestand = bestand;
	}
	

	/**
	 * @param zusatz muss immer > 0 sein
	 */
	public void zugang(int zusatz) {
		check(zusatz > 0, "Der Zusatz darf nicht <= 0 sein.");
		setBestand(this.bestand + zusatz);
	}

	/**
	 * @param absatz muss immer > 0 sein
	 */
	public void abgang(int absatz) {
		check(absatz > 0, "Der Abgang darf nicht <= 0 sein.");
		setBestand(this.bestand - absatz);
	}
	
	
	public String toString() {
		return "Artikel : " + getNummer() +
			   " Bezeichnung: " + getBezeichnung() + 
			   " Bestand: " + getBestand();
	}
}
