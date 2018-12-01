
/**
 * nuetzilche Methoden fuer die Lager-und Artikel Klassen.
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class helpers
{
    /**
     * IllegalArgumentException mit @msg zuruckgesendet, wenn die @bedigung falsch ist
     * @param bedigung  Die Bedigung
     * @param msg       Die Nachricht der Ausnahme
    */
   
    // error constants
    public final static int illegalArgumentException = 1;
    public final static int arrayIndexOutOfBoundsException = 2;
   
    public static void check(boolean bedigung, String nachricht) {
        check(bedigung, nachricht, illegalArgumentException);
    }
    public static void check(boolean bedigung, String nachricht, int exceptionId){
        if (!bedigung){
            switch(exceptionId){
                case illegalArgumentException:
                    throw new IllegalArgumentException(nachricht);
                
                case arrayIndexOutOfBoundsException:
                    throw new ArrayIndexOutOfBoundsException(nachricht);
            }
        }
    }
}
