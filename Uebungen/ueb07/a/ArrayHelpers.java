import java.util.Arrays;
/**
 * Some functions that helps to write better code with arrays
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class ArrayHelpers
{    
    /**
     * Copy the specified array and add the value to this new Array.
     * ! Not safe if the array is new or not initialized.
     * 
     * @param tab old array
     * @param str value added to the new array
     * @return array with the added value
     */
    public static String[] add(String[] array, String value){
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length-1] = value;
        return newArray;
    }
    
    /**
     * Return a copy with the value of the array given in argument. 
     * Patch the safety problem of ArrayHelpers.add 
     * 
     * @param array 
     * @param value will be inserted at the end of the array
     * @return new array with the new value
     */
    public static String[] insertEnd(String[] array, String value){
        if(array.length > 0 && array[array.length-1] == null){
            array[array.length-1] = value;
            return array;
        }
        else
            return add(array, value);
    }
    
    /**
     * Return the biggest length of the strings in the array
     */
    public static int max(String[] array){
        int bestLengthSoFar = 0;
        int currentLength;
        for(String str: array){
            currentLength = str.length();
            if(currentLength > bestLengthSoFar)
                bestLengthSoFar = currentLength;
        }
        return bestLengthSoFar;
    }
}
