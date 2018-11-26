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
    private static final short ISBN_LENGTH = 9;
    private static final int ISBN_SIZE = 100_000_000;
    private static final short ISBN_MOD = 11;
    public static final String MSG_ISBNRECHNER = "Der ISBN muss ein 9-stellige Nummer sein";
    // quadratischeGleichung Konstanten
    public static final double MIN_UPSILON = -1e-12;
    public static final double MAX_UPSILON = 1e-12;
    //
    public static final String MSG_BOUND = "Das Maximum muss > 0 sein.";
    public static final String MSG_MAX = MSG_BOUND;

    /**
     * Uebuerprueft, ob alle Argumente richtig sind. 
     * Wirft eine IllegalArgumentException mit @nachricht
     * 
     * @param bedigung wird ueberprueft
     * @param nachricht wenn Fehler
     */
    private static void check_arguments(boolean bedigung, String nachricht){
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
        check_arguments((n >= 1), MSG_TEILERSUMME);
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

        check_arguments((MIN_ISBN <= isbn && isbn <= MAX_ISBN), 
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
     * Gibt eine matrix zurueck, die {a,b,c} Elementen enthaelt.
     * Sowie a³+b³ = c²
     * 
     * @param max Die Obergrenze, muss einer int der > 0 ist sein
     * 
     * @return einem geeigneten Array
     */
    public static long[][] zahlentripelRechner(int max){
        // With strings, we can go upper than integer (size array limit)
        check_arguments(max > 0, MSG_BOUND);
        long[][] zahlentripel = new long[max][3];
        int found = 0; 
        long[] tripel;
        long square_c, cube_b, cube_a;
        for(long c=2; c < max; c++){
            square_c = c*c;
            for(long b=1; b <= c; b++){
                cube_b = b*b*b;
                if(cube_b > square_c) break;
                for(long a=1; a <= b; a++){
                    cube_a = a*a*a;
                    if(cube_a > square_c) break;
                    if(cube_a + cube_b == square_c){
                        tripel = new long[] {a, b, c};
                        zahlentripel[found++] = tripel;
                    }
                }
            }
        }
        return zahlentripel;
    }
    
    /**
     * Stellt die Array von Tripel (@see zahlentripelRechner) dar
     * 
     * @param tab Array von Tripel
     */
    public static void printTripelArray(long[][] tab){
       String s = "";
       for(int i=0; i<tab.length; i++){
           if(tab[i][0] == 0)
                break;
           s += "(" + tab[i][0] + "," +
                      tab[i][1] + "," +
                      tab[i][2] + "); ";
       }
       System.out.println(s.trim());   
    }
    /**
     * Methode, die die Array rechnet (@see zahlentripelRechner) und stellt
     * die Array dar.
     * 
     * @param max (@see zahlentripelRechner) 
     */
    public static void printTripelArray(int max){
        printTripelArray(zahlentripelRechner(max)); 
    }
       
    /**
     * Rechnet die mathematische folge
     * 
     * @param bound Grenze zu berechnen, muss einer int sein
     * @param x f(x), muss einer double der > 0 ist sein
     * 
     * @return die Resultat die mathematische folge
     */
    public static double mathematischeFolge(long n, double x){
        check_arguments(n > 0, MSG_BOUND);      
        double x1 = x-1;
        double x2 = x;
        double acc = x1/x2;
        double acc_x1 = x1;
        double acc_x2 = x2;
        
        for(long i=2; i <= n; i++){
            acc_x1 *= x1;
            acc_x2 *= x2;
            acc += acc_x1 / (i * acc_x2);
        }
        return acc;
    }
    
}
    
