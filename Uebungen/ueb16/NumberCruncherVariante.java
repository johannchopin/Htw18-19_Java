import java.util.Random;

/**
 * The implementation of the 2. Aufgabe  with anonymous classes
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class NumberCruncherVariante
{
    private float[] array;
    private Random randomizer;
    
    /**
     * TESTING constructor
     * Add the seed parameter to fix randomness
     */
    NumberCruncherVariante(int size, int seed)
    {
        this.array = new float[size];
        this.randomizer = new Random(seed);
        for(int i=0; i<size; i++)
            this.array[i] = randomizer.nextFloat() * 100;
    }
    
    /**
     * Create an array and fill it with random float number.
     * @param size fo the array
     */
    NumberCruncherVariante(int size)
    {
        this.array = new float[size];
        this.randomizer = new Random();
        for(int i=0; i<size; i++)
            this.array[i] = randomizer.nextFloat() * 100;
    }
    
    
    
    /**
     * @return the float array
     */
    public float[] getArray(){
        return this.array;
    }
    
    /**
     * Select the operation that has to be done. Then run it *in place*
     */
    public void crunch(String[] operations){
        Operation op;
        for(String opName: operations){
            switch(opName){
                case "sum":
                    op = new Sum();
                    break;
                    
                case "swirl":
                    op = new Swirl();
                    break;
                    
                case "divide":
                    op = new Divide();
                    break;
                    
                case "substract":
                    op = new Substract();
                    break;
                    
                case "average":
                    op = new Average();
                    break;
                    
                default:
                    throw new IllegalArgumentException(opName + " is not a valid operation");
            }
            array = op.doIt(array);
        }
    }
    
    public static void main(String[] args){
        NumberCruncher nb = new NumberCruncher(1000);
        for(float el: nb.getArray())
            System.out.print(el + ",");
        System.out.println();
        nb.crunch(new String[] {"divide"});
        for(float el: nb.getArray())
            System.out.print(el + ",");
        System.out.println();
    }
}
