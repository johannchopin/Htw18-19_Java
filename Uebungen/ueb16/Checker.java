
/**
 * Check funktionen
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Checker
{
    public static void checkArgs(boolean bedigung, String msg){
        if(!bedigung)
            throw new IllegalArgumentException(msg);
    }
}
