package src.artikel;

/**
 * 
 * Die Klasse simuliert ein Artikel
 * 
 * @author leparesseux
 * @version 1.0
 */
public class Artikel {
	private int nummer;
	private String bezeichnung;
	private int bestand;

	/**
	 * IllegalArgumentException mit @nachricht zurückgesendet, wenn die @bedigung
	 * falsch ist
	 * 
	 * @param bedigung
	 * @param nachricht die Nachricht der Ausnahme
	 */
	public void check(boolean bedigung, String nachricht) {
		if (!bedigung)
			throw new IllegalArgumentException(nachricht);
	}

	Artikel(int nummer, String bezeichnung, int bestand) {
		check(bezeichnung != null || !bezeichnung.isEmpty(), "Der Bezeichnung muss nicht leer sein.");
		check(999 < nummer && nummer < 10000, "Der Nummer muss 4-stellig sein");

		this.nummer = nummer;
		this.bezeichnung = bezeichnung;
		setBestand(bestand);
	}

	Artikel(int nummer, String bezeichnung) {
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
	 * 
	 * @param bestand muss immer >= 0 sein
	 */
	public void setBestand(int bestand) {
		check(bestand >= 0, "Der Bestand darf nicht < 0 werden.");
		this.bestand = bestand;
	}

	private void setBestand(int bestand, boolean bedigung, String nachricht) {
		check(bedigung, nachricht);
		this.bestand = bestand;
	}

	/**
	 * 
	 * @param zusatz muss immer > 0 sein
	 */
	public void zugang(int zusatz) {
		setBestand(this.bestand + zusatz, 
				zusatz > 0, "Der Zusatz muss > 0 sein");
	}

	/**
	 * 
	 * @param absatz muss immer > 0 und <= this.bestand sein
	 */
	public void abgang(int absatz) {
		setBestand(this.bestand - absatz, 
				0 < absatz && absatz <= this.bestand, "Der Absatz darf nicht < 0 sein");
	}

	public String toString() {
		return "Artikel : " + getNummer() + 
			   " Bezeichnung: " + getBezeichnung() + 
			   " Bestand: " + getBestand();
	}
}
