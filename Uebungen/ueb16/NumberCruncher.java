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
     * @param size fo the array
     */
    NumberCruncher(int size)
    {
        this.array = new float[size];
        this.randomizer = new Random();
        for(int i=0; i<size; i++)
            this.array[i] = randomizer.nextFloat();
    }
    
    /**
     * @return the float array
     */
    public float[] getArray(){
        return this.array;
    }
    
    public interface Operation{
        public void doIt();
    }
    
    /**
     * TODO: Comment this 
     */
    public void crunch(String[] operations){
        Operation op;
        for(String opName: operations){
            switch(opName){
                case "sum":
                    op = new Operation(){
                        public void doIt(){
                            int i = 1;
                            while(i < array.length)
                                array[i] += array[i++-1];
                        }
                    };
                    op.doIt();
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
                    throw new IllegalArgumentException(opName + " is not a valid operation");
            }
        }
    }
    
    public static void main(String[] args){
        NumberCruncher nb = new NumberCruncher(15);
        nb.crunch(new String[] {"sum"});
        for(float el: nb.getArray())
            System.out.println(el);
    }
}
