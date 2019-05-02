import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

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
    
    // Used to check if floats number are to close to 0
    public static final double lowBound = +0.1e-10;
    public static final double highBound = -0.1e-10;
    
    /**
     * Create an array and fill it with random float number .
     * @param size fo the array
     */
    NumberCruncher(int size)
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
    
    public interface Operation{
        public void doIt();
    }
    
    class ArrayElement 
              implements Comparator<ArrayElement>, Comparable<ArrayElement> {
        int   index;
        float value;
        
        ArrayElement(int index, float value){
            this.index = index;
            this.value = value;
        }
        
        public int compare(ArrayElement el1, ArrayElement el2){
            return Float.compare(el1.value, el2.value);
        }
        
        @Override
        public int compareTo(ArrayElement other){
            return compare(this, other); // Because already implemented
        }
    }
    
    /**
     * TODO: Comment this sheet
     */
    public void crunch(String[] operations){
        Operation op;
        for(String opName: operations){
            switch(opName){
                case "sum":
                    op = sum();
                    break;
                    
                case "swirl":
                    op = swirl();
                    break;
                    
                case "divide":
                    op = divide();
                    break;
                    
                case "substract":
                    op = substract();
                    break;
                    
                case "average":
                    op = average();
                    break;
                    
                default:
                    throw new IllegalArgumentException(opName + " is not a valid operation");
            }
            op.doIt();
        }
    }
    
    private Operation sum(){
        return new Operation(){
            public void doIt(){
                int i = 1;
                while(i < array.length)
                    array[i] += array[i++-1];
            }
        };
    }
    
    private Operation substract(){
        return new Operation(){
            public void doIt(){
                int i = 1;
                while(i < array.length)
                    array[i] -= array[i++-1];
            }
        };
    }
    
    private Operation swirl(){
        return new Operation(){
            public void doIt(){
                float aux;
                int pos1, pos2;
                for(int i = 0; i < array.length; i++){
                    pos1 = randomizer.nextInt(array.length);
                    pos2 = randomizer.nextInt(array.length);
                    aux = array[pos1];
                    array[pos1] = array[pos2];
                    array[pos2] = aux;
                }
            }
        };
    }
    
    private Operation divide(){
        return new Operation(){
            public void doIt(){
                ArrayElement[] arrayCp = new ArrayElement[array.length];
                for(int i=0; i < array.length; i++)
                    arrayCp[i] = new ArrayElement(i, array[i]);
                Arrays.sort(arrayCp);
                
                for(int j=0; j < array.length/2; j++){
                    if(lowBound <= arrayCp[j].value && arrayCp[j].value <= highBound)
                        throw new ArithmeticException("A float number is equal to 0. Division impossible.");
                    else
                        arrayCp[array.length - 1 - j].value /= arrayCp[j].value;
                }
                
                for(ArrayElement el: arrayCp){
                    array[el.index] = el.value;
                }
            }
        };
    }
    
    private Operation average(){
        return new Operation(){
            public void doIt() {  
                double acc = 0;
                ArrayElement biggestSoFar = 
                    new ArrayElement(-1, Float.MIN_VALUE);
                
                for(int i=0; i<array.length; i++){
                    acc += array[i];
                    if(array[i] >= biggestSoFar.value)
                        biggestSoFar = new ArrayElement(i, array[i]);                  
                }
                
                array[biggestSoFar.index] = (float)acc / array.length;
            }
        };
    }
    
    public static void main(String[] args){
        NumberCruncher nb = new NumberCruncher(1000_000);
        for(float el: nb.getArray())
            System.out.print(el + ",");
        System.out.println();
        nb.crunch(new String[] {"divide"});
        for(float el: nb.getArray())
            System.out.print(el + ",");
        System.out.println();
    }
}
