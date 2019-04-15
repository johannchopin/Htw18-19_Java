import java.lang.StringBuilder;
import java.util.LinkedList;
/**
 * A simple Raum
 *
 * @author Guidoux Alexandre
 * @version 1.0
 */
public class Raum
{
    private int geb, etage, raum;
    private LinkedList<Reservierung> reservierungen;
    
    /**
     * Constructor for objects of class Raum
     * @param geb der Nummer des Gebaedes
     * @param etage der Stock
     * @param raum der Nummer des Raums
     */
    public Raum(int geb, int etage, int raum)
    {
        h.checkArgs(geb > 0, "Der Gebaude ist unbekannt.");
        h.checkArgs(etage >= 0, "Falsche Etage eingeschrieben.");
        h.checkArgs(raum >= 0, "Falsche Nummer eingeschrieben.");
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
        this.reservierungen = new LinkedList<Reservierung>(); // Lagert die reservierung
    }

    void addReservierung(Reservierung r){
        reservierungen.add(r);
    }

    public String toString(){
        StringBuilder str = new StringBuilder("Raum " + this.geb + "-" + this.etage + "." + this.raum + "\n"); 
        if(reservierungen.size() > 0){
            for(Reservierung r : reservierungen)
                str.append(r.toString() + "\n");
        }
        return str.toString(); 
    }
}
