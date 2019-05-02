import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

/**
 * The implementation of the 2. Aufgabe  with anonymous classes
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
     * TESTING constructor
     * Add the seed parameter to fix randomness
     */
    NumberCruncher(int size, int seed)
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
    NumberCruncher(int size)
    {
        this.array = new float[size];
        this.randomizer = new Random();
        for(int i=0; i<size; i++)
            this.array[i] = randomizer.nextFloat() * 100;
    }
    
    public NumberCruncher(){
        this(10);
    }

    /**
     * @return the float array
     */
    public float[] getArray(){
        return this.array;
    }

    /**
     * Top-level interface. Each implementation have a doIt method which
     * do something on the float[]
     */
    public interface Operation{
        public void doIt();
    }

    /**
     * Simulate an element in a array. That is to say a value with an index.
     */
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
     * Select the operation that has to be done. Then run it *in place*
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

    /**
     * Implement the sum Operation : 
     * Summiert die Elemente des Arrays paarweise von links nach rechts auf 
     * und speichertden neuen Wert in dem jeweils rechten Datenfeld.
     */
    private Operation sum(){
        return new Operation(){
            public void doIt(){
                int i = 1;
                while(i < array.length)
                    array[i] += array[i++-1];
            }
        };
    }

    /**
     * Implement the substract Operation :
     * Analog zu sum nur mit Substraktion
     */
    private Operation substract(){
        return new Operation(){
            public void doIt(){
                int i = 1;
                while(i < array.length)
                    array[i] -= array[i++-1];
            }
        };
    }

    /**
     * Implement the swirl Operation :
     * Führt n zufällige Vertauschungen der Datenfelder durch;
     * n ist durch die Länge des float-Arrays gegeben.
     */
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

    /**
     * Implement the divide Operation :
     * Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten 
     * und speichert den neuenWert im Datenfeld des jeweils größeren Wertes. 
     * D.h. der größte Wert wird durch den Kleinsten geteilt. 
     * Der Zweitgrößte durch den Zweitkleinsten usw.
     */
    private Operation divide(){
        return new Operation(){
            public void doIt(){
                // Copy and sort the ArrayElement from the array
                ArrayElement[] arrayCp = new ArrayElement[array.length];
                for(int i=0; i < array.length; i++)
                    arrayCp[i] = new ArrayElement(i, array[i]);
                Arrays.sort(arrayCp);

                // Divide the lowest values by the highest
                for(int j=0; j < array.length/2; j++){
                    if(lowBound <= arrayCp[j].value && arrayCp[j].value <= highBound)
                        throw new ArithmeticException("A float number is equal to 0. Division impossible.");
                    else
                        arrayCp[array.length - 1 - j].value /= arrayCp[j].value;
                }

                // Rearrange the elements in good order (like the beginning)
                for(ArrayElement el: arrayCp)
                    array[el.index] = el.value;
            }
        };
    }

    /**
     * Implement the average Operation:
     * Bestimmt den Durchschnitt aller Werte im Array und 
     * speichert den Durchschnittswert im Datenfeld mit dem größten Wert.
     */
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
