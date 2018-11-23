/**
 * Versammlung von Funktionen
 * 
 * Enthaelt :
 * * Teilersumme eine naturliche Zahl
 * * eine Methode, die eine 10-ISBN ueberpruefen 
 * * eine Methode, um die quadratische Gleichungen zu loesen 
 *
 * @author Alexandre && Johann
 * @version 1.0
 */
public class FuncTools
{
    //  MSG Konstanten sind IllegalArgumentException Nachricht
    // teilerSumme Konstanten
    public static final String MSG_TEILERSUMME = "Der nummer muss > 0 sein.";
    // isbnRechner Konstanten
    private static final long MAX_ISBN = 999_999_999;
    private static final long MIN_ISBN = 111_111_111;
    public static final short ISBN_LENGTH = 9;
    private static final int ISBN_SIZE = 100_000_000;
    public static final short ISBN_MOD = 11;
    public static final String MSG_ISBNRECHNER = "Der ISBN muss ein 9-stellige Nummer sein";
    // quadratischeGleichung Konstanten
    public static final double MIN_UPSILON = -1e-12;
    public static final double MAX_UPSILON = 1e-12;
    

    /**
     * Uebuerprueft, ob alle Argumente richtig sind. 
     * Wirft eine IllegalArgumentException mit @nachricht
     * 
     * @param bedigung wird ueberprueft
     * @param nachricht wenn Fehler
     */
    private static void check(boolean bedigung, String nachricht){
        if(!bedigung)
            throw new IllegalArgumentException(nachricht);
    }

    /**
     * Berechnet die Teilersumme einer naturliche Zahl
     * 
     * @param n muss einer naturliche Zahl sein
     * 
     * @return Teilersumme einer naturliche Zahl
     */
    public static long teilerSumme(long n){
        check((n >= 1), MSG_TEILERSUMME);
        long acc = 1;

        if(n != 1)
            acc += n;
        for(long i = n/2; i > 1; i--){
            if(n % i == 0) {
                acc += i;
            }
        }
        return acc;
    }
    public static long teilerSumme(int n){
        return teilerSumme((long)n);
    }
    public static long teilerSumme(short n){
        return teilerSumme((long)n);
    }

    /**
     * Berechnet die Prüfziffer eines isbn
     * 
     * @param isbn muss einer long sein
     * 
     * @return die errechnete Prüfziffer
     */
    public static String isbnRechner(long isbn){
        int acc = 0;
        int divisor = ISBN_SIZE;
        int result;

        check((MIN_ISBN <= isbn && isbn <= MAX_ISBN), 
            MSG_ISBNRECHNER);

        for(short i=1; i < ISBN_LENGTH + 1; i++){
            acc += isbn/divisor * i;
            isbn %= divisor;
            divisor /= 10;
        }

        result = acc % ISBN_MOD;
        if(result == 10)
            return "X";
        return Integer.toString(result);
    }
    
    
    /**
     * Gibt die Quadratische Gleichungen von 2 nummer
     * 
     * @param p muss einer double sein
     * @param q muss einer double sein
     * 
     * @return der/die Nullstellen
     */
    public static String quadratischeGleichung(double p, double q){
        double x1, x2;
        double v = -p/2;
        double d = v*v - q;

        if(MIN_UPSILON <= d && d <= MAX_UPSILON){
            return "1 doppelte Nullstelle : " + v;
        }
        if(d > 0){
            x1 = v + Math.sqrt(d);
            x2 = v - Math.sqrt(d);
            return "2 reelle Nulstellen : " + x1 + " " + x2;
        }
        else
            return "2 komplexe Nullstellen";
    }
    
    
    /**
     * Gibt die Resultat eine mathematische Funktion
     * 
     * @param n muss einer int sein
     * @param q muss einer double der > 0 ist sein
     * 
     * @return die Resultat eine mathematische Funktion
     */public static double undefinierteFunktion(int n, double x) {
        check(x > 0, "variable x have to be > 0");
        double resultat = 0;
        for(int i = 1; i <= n; i++){
            double calc = Math.pow((x - 1), i) /  Math.pow(i * x, i);
            resultat += calc;
        }
        return resultat;
    }
}