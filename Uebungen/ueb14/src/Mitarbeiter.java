
/**
 * A Mitarbeiter herited from Person
 *
 * @author Guidoux Alexandre
 * @version 1.0
 */
public class Mitarbeiter extends Person
{
    private String email;
    
    /**
     * Constructor for objects of class Mitarbeiter
     */
    public Mitarbeiter(String vorname, String nachname, String email)
    {
        super(vorname, nachname);
        email = email.trim();
        h.checkArgs(email.length() > 0, "An email must be provided.");
        this.email = email;
    }

    public String toString(){
        return new String(super.toString() + " (" + this.email + ")"); 
    }
    
    /**
     * Reserviere ein Raum fuer eine bestimmte Zeit
     */
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung){
        Reservierung r = new Reservierung(beginn, ende);
        r.setBemerkung(bemerkung);
        r.setMitarbeiter(this);
        r.setRaum(raum);
        raum.addReservierung(r);
    }
}
