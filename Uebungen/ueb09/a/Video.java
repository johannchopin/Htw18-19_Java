
/**
 * Unterklasse Video der Obereklasse Artikel
 *
 * @author Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class Video extends Artikel
{
    private final static String MSG_ERSCHEINUNGSJAHR =
            "Die Erscheinungsjahr muss zwischen 1950 und 2014 sein.";
    private final static String MSG_SPIELDAUER = 
            "Der Spieldauer muss >= 1 sein.";
    
    private double spieldauer;
    private int erscheinungsjahr;
            
    /**
     * @see Artikel#Artikel(int, String, int, double)
     * @param spieldauer in Minuten und muss >= 1 sein.
     * @param erscheinungsjahr muss zwischen 1950 und 2014 sein.
     */
    public Video(int nummer, String titel, int bestand, double preis, double spieldauer, int erscheinungsjahr)
    {
        // The bezeichnung is the title
        super(nummer, titel, bestand, preis);
        
        Helpers.check((spieldauer >= 1),
                       MSG_SPIELDAUER);
        Helpers.check((1950 <= erscheinungsjahr) && (erscheinungsjahr <= 2014),
                      MSG_ERSCHEINUNGSJAHR);
        
        this.spieldauer = spieldauer;
        this.erscheinungsjahr = erscheinungsjahr;
    }
    
    public String getBeschreibung(){
        return this.bezeichnung;
    }
}
