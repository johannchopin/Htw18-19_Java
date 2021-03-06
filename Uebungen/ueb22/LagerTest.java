import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Comparator;
import java.util.List;

/**
 * A implementation for the Aufgabe 2.d bis 2.h
 *
 * @author Guidoux Alexandre
 * @version 1.0
 */
public class LagerTest
{
    public ArtikelLager lager;
    private final static int DEFAULT_LAGER_SIZE = 30;
    
    /**
     * Constructor
     * @param size groesse des Lagers
     */
    public LagerTest(int size)
    {
        LagerFabric lb = new LagerFabric(size);
        lager = lb.generateLager();
    }
    
    private void printList(List<Artikel> l){
        for(Artikel a: l)
            System.out.println(a);
    }

    //-----------------------------------------------------------------------
    // 18-2.d
    //-----------------------------------------------------------------------
    public void actions1(){
        // i
        BiPredicate<Artikel, Artikel> byBezeichnung  = (x, y) -> x.getBezeichnung().compareTo(y.getBezeichnung()) <= 0;
        BiPredicate<Artikel, Artikel> byBestand      = (x, y) -> x.getBestand() <= y.getBestand();
        Comparator<Artikel> byPreis        = (a1, a2) -> { // a1.getPreis().compareTo(a2.getPreis());
            double preis1 = a1.getPreis();
            double preis2 = a2.getPreis();
            if(preis1 > preis2)
                return 1;
            if(preis1 < preis2)
                return 0;
            return -1;
        };
        // Test i
        System.out.println("****Nach dem Preis sortiert"); 
        printList(lager.getSorted(byPreis));
        
        // ii
        Consumer<Artikel> rabatt10       = x -> x.changePreis(-0.10);
        // iii
        Consumer<Artikel> markAngebot    = x -> x.setBezeichnung("(Sonderangebot)" + x.getBezeichnung());
        // iv
        Consumer<Artikel> angebotAufAlle = rabatt10.andThen(markAngebot);
        // Test iv (+ ii + iii)
        lager.applyToArticles(angebotAufAlle);
        System.out.println("****-10% Rabatt auf alle Artikeln");
        System.out.println(lager);
    }
    
    //-----------------------------------------------------------------------
    // 18-2.h
    //-----------------------------------------------------------------------
    public void actions2(){
        // i
        Predicate<Artikel> isCD = x -> x instanceof CD;
        Consumer<CD>       cdRabatt = x -> x.changePreis(-0.10);
        // Test i
        System.out.println("****-10% Rabatt auf alle CDs");
        lager.applyToSomeArticle(isCD, cdRabatt);
        System.out.println(lager + "\n");
        
        // ii
        Predicate<Artikel> remainMoreThanOne = x -> x.getBestand() > 1;
        Consumer<Artikel>  rabatt5 = x -> x.changePreis(-0.05);
        // Test ii
        System.out.println("****-5% Rabatt auf Artikel mit mehr als 2 im Lager");
        lager.applyToSomeArticle(remainMoreThanOne, rabatt5);
        System.out.println(lager + "\n");
        
        // iii
        Predicate<Artikel> isBuch = x -> x instanceof Buch;
        Predicate<Artikel> isAuthorRowling = isBuch.and(
            x -> ((Buch) x).getAuthor().equals("J.K. Rowling")
        );

        // Test iii
        System.out.println("****-5% Rabatt auf J.K. Rowlings Buecher");
        lager.applyToSomeArticle(isAuthorRowling, rabatt5);
        System.out.println(lager + "\n");
        
        // iv (implemented as a procedure)
        Procedure iAndii = () -> {
            lager.applyToSomeArticle(isCD, cdRabatt);
            lager.applyToSomeArticle(remainMoreThanOne, rabatt5);
        };
        // Test iv
        System.out.println("****-10% Rabatt auf alle CDs\n" +
                           "****-5% Rabatt auf Artikel mit mehr als 2 im Lager");
        iAndii.invoke();
        System.out.println(lager + "\n");
        
        // Test v
        System.out.println("****Liste aller Buecher und nach Autor sortiert\n");
        printList(lager.getArticles(isBuch, (b1, b2) -> (((Buch)b1).getAuthor().compareTo(((Buch)b2).getAuthor()))));
        System.out.println();
        
        // vi
        Predicate<Artikel> minimumPrice10 = x -> x.getPreis() >= 10;
        // Test vi
        System.out.println("****Filterkriterien: ist eine CD, mindestPreis ist 10€ " +
                               "und bleibt mehr als ein CD uebrig \n");
        printList(lager.filterAll(isCD, minimumPrice10, remainMoreThanOne));
    }
    
    
    public static void main(String[] args){
        LagerTest shop = new LagerTest(DEFAULT_LAGER_SIZE);
        System.out.println("****Urspruengliches Lager\n" + shop.lager + "\n"); 
        shop.actions1();
        shop.actions2();
    }
}
