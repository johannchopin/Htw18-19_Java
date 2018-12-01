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
    private final static int MAX_LAGER_SIZE = 9999;
    // Error nachrichten
    public final static String ERR_LAGER_SIZE = 
                               "Der Groesse des Lagers muss > 0 sein.";
    public final static String ERR_LAGER_SIZE_2 =
                               "Der Groesse des Lagers muss <= 9999 sein. "+ 
                               "(Anmerkung: Artikels Nummer sind 4-stellig)";
    public final static String ERR_LAGER_VOLL =
                               "Der Lager ist voll. Nichts wird hinzugefuegt";
    
    private Artikel[] lager;
    private int totalItems;
    
    /**
     * @param lagerSize Groesse der Lager
     */
    public Lager(int lagerSize){
        helpers.check(lagerSize > 0, ERR_LAGER_SIZE);
        helpers.check(lagerSize <= MAX_LAGER_SIZE, ERR_LAGER_SIZE_2);
        this.lager = new Artikel[lagerSize];
        this.totalItems = 0;
    }
    /**
     * Erzeugt ein Lager aus Mangel an Parameter mit der MAX_LAGER_SIZE
     */
    public Lager(){this(MAX_LAGER_SIZE);}
    
    /**
     * Fuege ein neuer Artikel im Lager hinzu
     * 
     * @param nummer      Nummer des Artikels
     * @param bezeichnung Nummer des Artikels
     * @param bestand     Bestand des Artikels
     */
    public void anlegen(int nummer, String bezeichnung, int bestand){
        Artikel neuerArtikel = new Artikel(nummer, bezeichnung, bestand);
        anlegen(neuerArtikel);
    }
    /**
     * Fuege ein neuer Artikel im Lager hinzu
     * 
     * @param neuerArtikel Der Artikel, der gelagert wird
     */
    public void anlegen(Artikel neuerArtikel){
        helpers.check(this.totalItems < this.lager.length, 
                      ERR_LAGER_VOLL, 
                      helpers.arrayIndexOutOfBoundsException);
        this.lager[this.totalItems++] = neuerArtikel;
    }
    
    private Artikel[] removeArtikel(Artikel[] tab, int start){
        for(int i=start; i < tab.length-1; i++){
            tab[i] = tab[i+1];
        }
        tab[tab.length-1] = null;
        this.totalItems -= 1;
        return tab;
    }
    
    /** TODO
     * Loescht einen Artikel des Lagers
     * 
     * @param id_artikel die Kennung des Artikels
     */
    public void entfernen(int id_artikel){
        int index = -1;
        for(int i=0; i < this.totalItems; i++){
            if (id_artikel == this.lager[i].getNummer()){
                this.lager = removeArtikel(this.lager, i);
                return;
            }
        }
        throw new ArrayStoreException("ID not found im Lager");
    }
    
    /**
     * Sucht die Stellung eines Artikels dank seiner Kennung
     * 
     * @param id_artikel die Kennung des Artikels
     */
    private int searchPositionById(int id_artikel){
        for(int i=0; i < this.totalItems; i++){
            if(i == this.lager[i].getNummer())
                return i;
        }
        return -1;
    }
    
    /** USEFUL ?
     * Sucht die Stellung eines Artikels dank seiner Kennung
     * 
     * @param bezeichnung die bezeichnung des Artikels
     */
    private int searchPositionByName(String bezeichnung){
        for(int i=0; i < this.totalItems; i++){
            if(bezeichnung.equals(this.lager[i].getBezeichnung()))
                return i;
        }
        return -1;
    }
    
    public String toString(){
        StringBuffer strBuffer = new StringBuffer();
        for(int i = 0; i < this.totalItems; i++){
            
        }
        strBuffer.trimToSize();
        return strBuffer.toString();
    }
}
