import java.lang.StringBuffer;

/**
 * Ermoglicht, verschiedene Artikel-Objekten in einer Tabelle zu lagern.
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Lager
{
    // Konstanten
    private final static int MAX_LAGER_SIZE             = 9999;
    private final static int DEFAULT_BUFFER_STR_SIZE = 1024;
    // Error nachrichten
    public final static String ERR_LAGER_SIZE = 
                       "Der Groesse des Lagers muss > 0 und <= 9999 sein." +
                       "(Anmerkung: Artikels Nummer sind 4-stellig)";
    public final static String ERR_LAGER_VOLL =
                       "Der Lager ist voll. Nichts wird hinzugefuegt";
    public final static String ERR_ARTIKEL_NICHT_GEFUNDEN = 
                       "Artikel wurde nicht im Lager gefunden.";
    
    private Artikel[] lager;
    private int totalItems;
    
    /**
     * Erzeugt ein Lager
     * 
     * @param lagerSize Groesse der Lager
     */
    public Lager(int lagerSize){
        helpers.check(0 < lagerSize && lagerSize <= MAX_LAGER_SIZE, 
                      ERR_LAGER_SIZE);
        this.lager = new Artikel[lagerSize];
        this.totalItems = 0;
    }
    /**
     * Erzeugt ein Lager ohne Parameter 
     * Standartmaessig wird das Objekt mit der MAX_LAGER_SIZE erzeugt
     */
    public Lager(){this(MAX_LAGER_SIZE);}

    /**
     * Sucht die Stellung eines Artikels dank seiner Kennung
     * 
     * @param id_artikel die Kennung des Artikels
     */
    private int searchPositionById(int id_artikel){
        for(int i=0; i < this.totalItems; i++){
            if(id_artikel == this.lager[i].getNummer())
                return i;
        }
        return -1;
    }
    
    /**
     * Fuege ein neuer Artikel im Lager hinzu. Main anlegen
     * 
     * @param neuerArtikel Der Artikel, der gelagert wird
     */
    public void anlegen(Artikel neuerArtikel){
        helpers.check(this.totalItems < this.lager.length, 
                      ERR_LAGER_VOLL, 
                      helpers.ARRAY_OUT_OF_BOUND_EXCEPTION);
        // Check if an artikel has the same ID
        for(int i = 0; i < this.totalItems; i++){
            if(lager[i].getNummer() == neuerArtikel.getNummer())
                throw new ArrayStoreException("Diese Kennung ist schoen benutzt.");
        }             
        this.lager[this.totalItems++] = neuerArtikel;
    }
    /**
     * Fuege ein neuer Artikel im Lager hinzu
     * 
     * @param nummer      Nummer des Artikels
     * @param bezeichnung Nummer des Artikels
     * @param bestand     Bestand des Artikels
     * @param preis       Preis des Artikels
     */
    public void anlegen(int nummer, String bezeichnung, int bestand, double preis){
        anlegen(new Artikel(nummer, bezeichnung, bestand, preis));
    }
    public void anlegen(int nummer, String bezeichnung){
        anlegen(new Artikel(nummer, bezeichnung));
    }
    public void anlegen(int nummer, String bezeichnung, int bestand){
        anlegen(new Artikel(nummer, bezeichnung, bestand));
    }
    public void anlegen(int nummer, String bezeichnung, double preis){
        anlegen(new Artikel(nummer, bezeichnung, preis));
    }
    
    /**
     * Loescht den bestimmten Artikel und setzt sich die Indexe 
     * von @start bis das Ende des Lagers weiter.
     * 
     * @param tab der Lager
     * @param start 
     * @return tab der Lager
     */
    private Artikel[] removeArtikel(Artikel[] tab, int start){
        for(int i=start; i < tab.length-1; i++){
            tab[i] = tab[i+1];
        }
        tab[tab.length-1] = null;
        this.totalItems -= 1;
        return tab;
    }
    
    /**
     * Loescht einen Artikel des Lagers
     * 
     * @param id_artikel die Kennung des Artikels
     * @throws ArrayStoreException wenn @id_artikel nicht gefunden
     */
    public void loeschen(int id_artikel){
        int index = searchPositionById(id_artikel);
        if (index >= 0)
            this.lager = removeArtikel(this.lager, index);
        else
            throw new ArrayStoreException(ERR_ARTIKEL_NICHT_GEFUNDEN);
    }
    
    /**
     * Fuegue der Abstatz zum Artikel mit der Kennung hinzu
     * 
     * @param id_artikel die Kennung des Artikels (o. Nummer)
     * @param absatz     dem Absatz den Bestand hinzufuegen
     */
    public void artikelZugang(int id_artikel, int zusatz){
        int index = searchPositionById(id_artikel);
        if(index != -1)
            this.lager[index].zugang(zusatz);
        else
            throw new ArrayStoreException(ERR_ARTIKEL_NICHT_GEFUNDEN);
    }
    
    /**
     * Loescht der Absatz von einem Artikel mit der Kennung.
     *
     * @param id_artikel die Kennung des Artikels (o. Nummer)
     * @param absatz     dem Absatz den Bestand hinzufuegen
     */
    public void artikelAbgang(int id_artikel, int absatz){
        int index = searchPositionById(id_artikel);
        if(index != -1)
            this.lager[index].abgang(absatz);
        else
            throw new ArrayStoreException(ERR_ARTIKEL_NICHT_GEFUNDEN);
    }
    
    /**
     * Veraendert den Preis eines Artikels mit einem prozentsatz
     * 
     * @param id_artikel die Kennung des Artikels (o. Nummer)
     * @param prozensatz 
     */
    public void artikelPreisAendern(int id_artikel, double prozentsatz){
        int index = searchPositionById(id_artikel);
        if(index != -1)
            this.lager[index].ChangePreis(prozentsatz);
        else
            throw new ArrayStoreException(ERR_ARTIKEL_NICHT_GEFUNDEN);
    }
    
    /**
     * Darstellung des Lagers
     * 
     * @return String Ein Objekt des Lagers pro Zeile
     */
    public String toString(){
        String ItemBuffer = new String();
        StringBuffer strBuffer = new StringBuffer(DEFAULT_BUFFER_STR_SIZE);
        
        strBuffer.append(String.format(
             "#Lager\nGroesse: %d, Artikel gelagert: %d\n",
             this.lager.length, this.lager.totalItems);
             
        for(int i = 0; i < this.totalItems; i++){
            ItemBuffer = this.lager[i].toString() + "\n";
            
            if(ItemBuffer.length() > strBuffer.capacity()) 
                strBuffer.ensureCapacity(ItemBuffer.length());
            
            strBuffer.append(ItemBuffer);
        }
        
        strBuffer.trimToSize();
        return strBuffer.toString();
    }
}
