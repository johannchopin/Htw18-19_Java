/**
 * @author leparesseux
 *
 */
public class Artikel {
	private int nummer;
	private String bezeichnung;
	private int bestand;
	
	Artikel(int nummer, String bezeichnung, int bestand) {
		if (bezeichnung == null || bezeichnung.isEmpty())
			throw new IllegalArgumentException("Der Bestand muss nicht leer sein.");
		
		this.nummer = nummer;
		this.bezeichnung = bezeichnung;
		this.bestand = bestand;
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
		if (bestand < 0)
			throw new IllegalArgumentException("Der Bestand darf nicht < 0 werden");
		this.bestand = bestand;
	}

	public String toString() {
		return "Artikel : " + getNummer() +
			   " Bezeichnung: " + getBezeichnung() + 
			   " Bestand: " + getBestand();
	}
	
	public void zugang(int zusatz) {
		this.bestand += zusatz;
	}
	
	public void abgang(int absatz) {
		this.bestand -= absatz;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("OK ! :)");
		
		Artikel Artikel1 = new Artikel(42, "staubsauger", 10);
		System.out.println(Artikel1);
	}	
}
