/**
 * Implement the substract Operation :
 * Analog zu sum nur mit Substraktion
 * 
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Substract implements Operation{
    public float[] doIt(float[] array){
        int i = 1;
        while(i < array.length)
            array[i] -= array[i++-1];
        return array;
    };
}