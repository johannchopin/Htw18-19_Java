import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Consumer;

/**
 * Ermoglicht, verschiedene Artikel-Objekten in einer Tabelle zu lagern.
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class ArtikelLager
{
    // Konstanten
    private final static int    MAX_LAGER_SIZE          = 9999;
    private final static int    DEFAULT_BUFFER_STR_SIZE = 1024;
    private final static String DEFAULT_ORT             = "Alt-Saarbrucken";
    private final static int    ZEILE_FORMAT_SIZE       =  81;
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
    private String lagerOrt;
    
    
    /**
     * Erzeugt ein Lager
     * 
     * @param lagerSize Groesse der Lager
     */
    public ArtikelLager(int lagerSize, String lagerOrt){
        Helpers.check(0 < lagerSize && lagerSize <= MAX_LAGER_SIZE, 
                      ERR_LAGER_SIZE);
        this.lager = new Artikel[lagerSize];
        this.totalItems = 0;
        this.lagerOrt = lagerOrt;
    }
    public ArtikelLager(int lagerSize){
        this(lagerSize, DEFAULT_ORT);
    }
    /**
     * Erzeugt ein Lager ohne Parameter 
     * Standartmaessig wird das Objekt mit der MAX_LAGER_SIZE und DEFAULT_ORT erzeugt
     */
    public ArtikelLager(){
        this(MAX_LAGER_SIZE, DEFAULT_ORT);
    }

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
        Helpers.check(this.totalItems < this.lager.length, 
                      ERR_LAGER_VOLL, 
                      Helpers.ARRAY_OUT_OF_BOUND_EXCEPTION);
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
            this.lager[index].changePreis(prozentsatz);
        else
            throw new ArrayStoreException(ERR_ARTIKEL_NICHT_GEFUNDEN);
    }
    
    /**
     * Gibt der aktuell Anzahl der Artikel im Lager zurueck
     */
    public int getArtikelNumber(){
        return this.totalItems;
    }
    
    /**
     * Darstellung des Lagers
     * 
     * @return String Ein Objekt des Lagers pro Zeile
     */
    public String toString(){
        StringBuffer strBuffer = new StringBuffer(DEFAULT_BUFFER_STR_SIZE);
        
        
        strBuffer.append("Lagerort: " + this.lagerOrt + '\n')
                 .append('\n')
                 .append(String.format("%-4s  %-50s  %-5s  %-7s  %6s \n", 
                         "ArtNr", "Beschreibung", "Preis", "Bestand", "Gesamt"))
                 .append(String.format(Helpers.repeat("-",ZEILE_FORMAT_SIZE) + '\n'));
             
        for(int i = 0; i < this.totalItems; i++)
            strBuffer.append(this.lager[i] + "\n");
        
        strBuffer.append(String.format(Helpers.repeat("-", ZEILE_FORMAT_SIZE) + '\n'))
                 .append(String.format("Gesamtwert: %69.2f\n", lagerSumme()));
            
        strBuffer.trimToSize();
        return strBuffer.toString();
    }
    
    /**
     * @return der Preis der gesamten Produkte
     */
    private double lagerSumme(){
        double summe = 0;
        for(int i=0; i<totalItems; i++)
            summe += this.lager[i].getPreis() * this.lager[i].getBestand();
        return summe;
    }

    // ----------------------------------------------------------------------
    //  18-2.a implementation sort
    // ----------------------------------------------------------------------
    private Artikel[] getSorted(BiPredicate<Artikel, Artikel> predicate, Artikel[] arr){                
        int size = arr.length-1;
        Artikel swapArtikel = null;
        for(int i=1; i<size; i++){
            if(arr[i] == null)
                    return arr;
            for(int j=0; j<size; j++){
                if(arr[j+1] == null)
                    break;
                if(predicate.test(arr[j+1], arr[j])){
                    swapArtikel = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swapArtikel;
                }
            }
        }      
        return arr;
    }
    
    /**
     * Sortiert des Lagers nach dem Bipraedikat. 
     * Das BubbleSort Algorithmus wird benutzt.
     * The Bipredicate return true if the first argument is "smaller".
     * 
     * @param BiPredicate<Artikel, Artikel> Das Sortierkriteriums fuer 2 Artikels
     * @return List<Artikel> Sortierte Lager
     */
    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> predicate){
        return getSorted(predicate, lager.clone());
    }
    
    // ----------------------------------------------------------------------
    //  18-2.b implementation filter
    // ----------------------------------------------------------------------
    public Artikel[] filter(Predicate<Artikel> rule) {
        ArrayList<Artikel> filtered = new ArrayList<Artikel>();
        int artikelInLager = getArtikelNumber();
        for(int i=0; i<artikelInLager; i++){
            if(rule.test(lager[i]))
                filtered.add(lager[i]);
        }
        return filtered.toArray(new Artikel[filtered.size()]);
    }
    
    private Artikel[] filter(Predicate<Artikel> rule, Artikel[] arr) {
        ArrayList<Artikel> filtered = new ArrayList<Artikel>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == null)
                return filtered.toArray(new Artikel[filtered.size()]);
            if(rule.test(arr[i]))
                filtered.add(arr[i]);
        }
        return filtered.toArray(new Artikel[filtered.size()]);
    }
    
    // ----------------------------------------------------------------------
    //  18-2.c implementation ApplyToArticles
    // ----------------------------------------------------------------------
    public void applyToArticles(Consumer<Artikel> c){
        int artikelInLager = getArtikelNumber();
        for(int i=0; i<artikelInLager; i++){
            c.accept(lager[i]);
        }
    }
    
    // ----------------------------------------------------------------------
    // 18-2.e implementation applyToSomeArticle
    // ---------------------------------------------------------------------
    public void applyToSomeArticle(Predicate predicate, Consumer consumer){
        for(Artikel a: filter(predicate)){
                consumer.accept(a);
        }
    }
    /*public void applyToSomeArticle(Predicate predicate, Consumer consumer){
        int artikelInLager = getArtikelNumber();
        for(int i=0; i<artikelInLager; i++){
            if(predicate.test(lager[i]))
                consumer.accept(lager[i]);
        }
    }*/
    
    // ----------------------------------------------------------------------
    // 18-2.f implementation getArticles 
    // ---------------------------------------------------------------------
    public Artikel[] getArticles(Predicate<Artikel> filterCriterion,
                                BiPredicate sortCriterion){
        return getSorted(sortCriterion, filter(filterCriterion));
    }
    
    // ----------------------------------------------------------------------
    // 18-2.g implementation filterAll
    // ---------------------------------------------------------------------
    public Artikel[] filterAll(Predicate<Artikel> ...filterCriteria){
        Artikel[] arr = lager.clone();
        for(Predicate<Artikel> criterion: filterCriteria){
            arr = filter(criterion, arr);
        }
        return arr;
    }
}
