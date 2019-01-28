
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
    
    public static int max(int... integers){
        int bestSoFar = Integer.MIN_VALUE;
        for(int integer: integers){
            if(integer > bestSoFar)
                bestSoFar = integer;
        }
        return bestSoFar;
    }
}
