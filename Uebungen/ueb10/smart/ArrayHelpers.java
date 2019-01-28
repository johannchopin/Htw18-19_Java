
/**
 * Functions for manipulating arrays structure
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class ArrayHelpers
{
    public static void removeItem(Object[] arr, int pos){
        int i = pos;
        while(i<arr.length-1)
            arr[i] = arr[++i];
        arr[i] = null;
    }
}
