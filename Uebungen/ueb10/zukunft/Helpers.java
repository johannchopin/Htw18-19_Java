
/**
 * Some useful functions
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Helpers
{
    public static void checkArgs(boolean condition, String msg){
        if(!(condition))
            throw new IllegalArgumentException(msg);
    }
}
