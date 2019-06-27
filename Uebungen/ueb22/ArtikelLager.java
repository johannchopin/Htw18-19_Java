import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;

/**
 * Ermoglicht, verschiedene Artikel-Objekten in einer Tabelle zu lagern.
 *
 * @author Alexandre Guidoux
 * @version 2.0
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
    
    private ArrayList<Artikel> lager;
    private int totalItems;
    private String lagerOrt;
    private int maxitem;
    
    /**
     * Erzeugt ein Lager
     * 
     * @param lagerSize Groesse der Lager
     */
    public ArtikelLager(int lagerSize, String lagerOrt){
        Helpers.check(0 < lagerSize && lagerSize <= MAX_LAGER_SIZE, 
                      ERR_LAGER_SIZE);
        this.lager = new ArrayList<Artikel>(lagerSize);
        this.maxitem = lagerSize;
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
            if(id_artikel == this.lager.get(i).getNummer())
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
        Helpers.check(this.maxitem >= this.lager.size(), 
                      ERR_LAGER_VOLL, 
                      Helpers.ARRAY_OUT_OF_BOUND_EXCEPTION);
        // Check if an artikel has the same ID
        for(int i = 0; i < this.totalItems; i++){
            if(lager.get(i).getNummer() == neuerArtikel.getNummer())
                throw new ArrayStoreException("Diese Kennung ist schoen benutzt.");
        }             
        this.lager.add(neuerArtikel);
        this.totalItems++;
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
     * Loescht einen Artikel des Lagers
     * 
     * @param id_artikel die Kennung des Artikels
     * @throws ArrayStoreException wenn @id_artikel nicht gefunden
     */
    public void loeschen(int id_artikel){
        int index = searchPositionById(id_artikel);
        if(index < 0)
            throw new ArrayStoreException(ERR_ARTIKEL_NICHT_GEFUNDEN);
        this.lager.remove(index);
            
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
            this.lager.get(index).zugang(zusatz);
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
            this.lager.get(index).abgang(absatz);
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
            this.lager.get(index).changePreis(prozentsatz);
        else
            throw new ArrayStoreException(ERR_ARTIKEL_NICHT_GEFUNDEN);
    }
    
    /**
     * Gibt der aktuell Anzahl der Artikel im Lager zurueck
     */
    public int getArtikelNumber(){
        return this.lager.size();
    }
    
    public Artikel get(int index){
        return this.lager.get(index);
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
             
        for(Artikel a: this.lager)
            strBuffer.append(a + "\n");
        
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
            summe += this.lager.get(i).getPreis() * this.lager.get(i).getBestand();
        return summe;
    }

    // ----------------------------------------------------------------------
    //  18-2.a implementation sort
    // ----------------------------------------------------------------------
    /**
     * Sortiert des Lagers nach dem Comparator. 
     * Das BubbleSort Algorithmus wird benutzt.
     * The Bipredicate return true if the first argument is "smaller".
     * 
     * @param BiPredicate<Artikel, Artikel> Das Sortierkriteriums fuer 2 Artikels
     * @return List<Artikel> Sortierte Lager
     */
    public List<Artikel> getSorted(Comparator<Artikel> comparator){
        return ((ArrayList<Artikel>)lager.clone()).stream()
               .sorted(comparator)
               .collect(Collectors.toList());
    }
    
    // ----------------------------------------------------------------------
    //  18-2.b implementation filter
    // ----------------------------------------------------------------------
    public List<Artikel> filter(Predicate<Artikel> rule) {
        return lager.stream()
                .filter(rule)
                .collect(Collectors.toList());
    }
    
    // ----------------------------------------------------------------------
    //  18-2.c implementation ApplyToArticles
    // ----------------------------------------------------------------------
    public void applyToArticles(Consumer<Artikel> c){
        lager.stream().forEach(a -> c.accept(a));
    }
    
    // ----------------------------------------------------------------------
    // 18-2.e implementation applyToSomeArticle
    // ---------------------------------------------------------------------
    public void applyToSomeArticle(Predicate predicate, Consumer consumer){
        lager.stream().filter(predicate).forEach(a -> consumer.accept(a));
    }
    
    // ----------------------------------------------------------------------
    // 18-2.f implementation getArticles 
    // ---------------------------------------------------------------------
    public List<Artikel> getArticles(Predicate<Artikel> filterCriterion,
                                     Comparator<Artikel> sortCriterion){
        return lager.stream()
                .filter(filterCriterion).sorted(sortCriterion)
                .collect(Collectors.toList());
    }
    
    // ----------------------------------------------------------------------
    // 18-2.g implementation filterAll
    // ---------------------------------------------------------------------
    public List<Artikel> filterAll(Predicate<Artikel> ...filterCriteria){
        Predicate<Artikel> accPredicate =  x->true;
        return lager.stream()
                .filter(
                    Arrays.asList(filterCriteria).stream().reduce(
                        accPredicate, 
                        (x, y) -> x.and(y))
                    )
                .collect(Collectors.toList());
    }
}
