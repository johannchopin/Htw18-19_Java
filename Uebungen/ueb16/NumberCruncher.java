import java.util.Random;

/**
 * The implementation of the 2. Aufgabe
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class NumberCruncher
{
    private float[] array;
    private Random randomizer;
    
    /**
     * Create an array and fill it with random float number .
     * Used for testing.
     * @param size fo the array
     */
    NumberCruncher(int size, int seed)
    {
        this.array = new float[size];
        this.randomizer = new Random(seed);
        for(int i=0; i<size; i++)
            this.array[i] = randomizer.nextFloat();
    }
    
    /**
     * Alias if seed not provided. Used for production.
     */
    public NumberCruncher(int size)
    {
        this(size, 0);
    }
    
    /**
     * @return the float array
     */
    public float[] getArray(){
        return this.array;
    }
    
    private interface Operation{
        public float[] run(float[] arr);
    }
    
    /**
     * TODO: Comment this 
     */
    public void crunch(String[] operations){
        for(String op: operations){
            switch(op){
                case "sum":
                    break;
                    
                case "swirl":
                    break;
                    
                case "divide":
                    break;
                    
                case "substract":
                    break;
                    
                case "average":
                    break;
                    
                default:
                    throw new IllegalArgumentException(op + " is not a valid operation");
            }
        }
    }
    
    public static void main(String[] args){
        NumberCruncher nb = new NumberCruncher(10);
        for(float el: nb.getArray())
            System.out.println(el);
    }
}
