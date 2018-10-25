/**
 * @author johannchopin
 * @version 1.0
 */

public class Artikel {
	
	int nummer;
	String bezeichnung;
	int bestand;
	
	Artikel(int nummer, String bezeichnung, int bestand) {
		this.nummer = nummer;
		this.bezeichnung = bezeichnung;
		this.bestand = bestand;
	}
	
	Artikel(int nummer, String bezeichnung) {
		this(nummer, bezeichnung, 0);
	}
	
	// Here are the getters
	public int getNummer() {
		return nummer;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}		
	
	public int getBestand() {
		return bestand;
	}

	// Here are the setters
	public void setBestand(int bestand) {
		this.bestand = bestand;
	}
	
	
	public String toString() {
		return "Artikel: " + getNummer() + 
				" Bezeichnung: " + getBezeichnung() + 
				" Bestand: " + getBestand();
	}

	public static void main(String[] args) {
		Artikel chemise = new Artikel(20, "chemise");
		System.out.println(chemise.toString());

	}

}
