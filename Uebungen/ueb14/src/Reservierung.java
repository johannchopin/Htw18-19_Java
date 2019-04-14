
/**
 * Simple reservation object
 *
 * @author Guidoux Alexandre
 * @version 1.0
 */
public class Reservierung
{
    private String bemerkung;
    private Uhrzeit beginn, ende;
    private Mitarbeiter mitarbeiter;
    private Raum raum;
    
    /**
     * Reservierung Constructor
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende)
    {
    	h.checkArgs(beginn.compareTo(ende) == -1, "The first Uhrzeit can't be after or at the same time of the second one");
        this.beginn = beginn;
        this.ende = ende;
    }
    
    public void setBemerkung(String bemerkung){
        bemerkung = bemerkung.trim();
        h.checkArgs(bemerkung.length() > 0, "Die Bemerkung ist leer.");
        this.bemerkung = bemerkung;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter){
        this.mitarbeiter = mitarbeiter;
    }
    
    public void setRaum(Raum raum){
        this.raum = raum;
    }
    
    public String toString(){
        return new String("gebucht von " + this.mitarbeiter + 
                          " von " + this.beginn + " bis " + this.ende +
                          " fuer " + this.bemerkung);
    }
}
