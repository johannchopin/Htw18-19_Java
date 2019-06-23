import java.util.Random;
import java.util.Queue;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Gibt integer zurueck and wird entweder in einer Queue oder in einem 
 * PriorityQueue gespeichert.
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class IntegerProducer
{
    private Random intGen;
    private Queue<Integer> storage;

    /**
     * Constructor for objects of class IntegerGenerator
     * @param ordered check if the generated integer must be sorted in 
     * the collection
     */
    public IntegerProducer(boolean ordered)
    {
        this.intGen = new Random();
        this.storage  = (ordered)? new PriorityQueue(): new LinkedList();
    }

    /**
     * Return and store an integer between 0 and 1000
     */
    public int produce(){
        int product = intGen.nextInt(1000);
        this.storage.add(product);
        return product;
    }
    
    /**
     * Shortcut to generate many numbers
     * Warning : produce return a int, produceMany return nothing
     */
    public void produceMany(int n){
        while(n-- > 0)
            produce();
    }
    
    /**
     * This method remove the int of the queue.
     * @return the next int in the queue or null if the queue is empty
     * @throw NoSuchElementException if the queue is empty
     */
    public int getNextInt(){
        return storage.remove();
    }
}
