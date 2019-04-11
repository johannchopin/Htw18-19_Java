/**
 * Some helpers methods
 *
 * @author Guidoux Alexandre
 * @version 1.0
 */
public class h
{
    public static void checkArgs(boolean condition, String msg){
        if(!(condition))
            throw new IllegalArgumentException(msg);
    }
}
