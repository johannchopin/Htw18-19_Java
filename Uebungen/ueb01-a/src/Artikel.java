/**
 * 
 * Die Klasse simuliert ein Artikel
 * 
 * @author leparesseux
 */
public class Artikel {
	private int nummer;
	private String bezeichnung;
	private int bestand;
	
	/**
	 * IllegalArgumentException mit @msg zurückgesendet, wenn die @bedigung falsch ist
	 * @param bedigung
	 * @param msg die Nachricht der Ausnahme
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
	 *  
	 * @param bestand muss immer >= 0 sein
	 */
	public void setBestand(int bestand) {
		check(bestand >= 0, "Der Bestand darf nicht < 0 werden.");
		this.bestand = bestand;
	}
	
	public String toString() {
		return "Artikel : " + getNummer() +
			   " Bezeichnung: " + getBezeichnung() + 
			   " Bestand: " + getBestand();
	}
	
	public void zugang(int zusatz) {
		check(zusatz > 0, "Der Zusatz darf nicht <= 0 sein.");
		setBestand(this.bestand + zusatz);
	}

	/**
	 *  
	 * @param absatz muss immer <= this.bestand sein
	 */
	public void abgang(int absatz) {
		check(absatz > 0, "Der Zusatz darf nicht <= 0 sein.");
		setBestand(this.bestand - absatz);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("OK ! :)");
		
		Artikel Artikel1 = new Artikel(4242, "staubsauger", 10);
		System.out.println(Artikel1);
		Artikel1.abgang(10);
		System.out.println(Artikel1);
		Artikel1.zugang(10);
		System.out.println(Artikel1);
	}	
}
