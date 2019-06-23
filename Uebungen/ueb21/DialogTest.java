import java.util.Random;
import java.util.NoSuchElementException;

/**
 * A Test class for the Integer Producer and Consumer
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class DialogTest
{
    private IntegerConsumer consumer;
    private IntegerProducer producer;
    private Random rand;
    
    public DialogTest(boolean ordered){
        this.consumer = new IntegerConsumer();
        this.producer = new IntegerProducer(ordered);
        this.rand     = new Random();
    }
    
    public void init(){
        for(int i = 0; i<10000; i++){
            if(rand.nextInt(2) > 0){
                producer.produce();
            }
            else{
                try{
                    consumer.consume(producer.getNextInt());      
                } catch(NoSuchElementException e){
                    i--;
                }
            }
        }
    }
    
    public void printState(){
        System.out.println("Number of different results: " + consumer.numberOfDifferentResults());
        System.out.println("=================================");
        for(int i=0; i<consumer.numberOfDifferentResults(); i++){
            System.out.println();
            System.out.println("Number " + i);
            System.out.println("Number of occurences:      " + 
                                consumer.numberOfOccurences(i));
            // Warning : a heap will be printed, not a sorted queue
            System.out.println("Get cross total ascending: " + 
                                consumer.getCrossTotalsAscending(i));
            // Warning : a heap will be printed, not a sorted queue
            System.out.println("And reversed:              " + 
                                consumer.getCrossTotalsDescending(i));
        }
    }
    
    public void run(){
        init();
        printState();
    }
    
    public static void main(String[] args){
        new DialogTest(args.length > 0).run();
    }
}
