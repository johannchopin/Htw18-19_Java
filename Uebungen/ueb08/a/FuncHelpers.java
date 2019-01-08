
/**
 * Some helpful functions
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class FuncHelpers
{
    public static void checkArguments(boolean bedigung, String nachricht){
        if(!bedigung)
            throw new IllegalArgumentException(nachricht);
    }
    
    public static void checkIndexBounds(boolean bedigung, String nachricht){
        if(!bedigung)
            throw new IndexOutOfBoundsException(nachricht);
    }
}
