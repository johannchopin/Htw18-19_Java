import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Collections;
/**
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class IntegerConsumer
{
    private HashMap<Integer, HashSet<Long>> results;
    private static final HashSet<Long> emptySet = new HashSet<>();
    
    public IntegerConsumer(){
        this.results = new HashMap<Integer, HashSet<Long>>();
    }
    
    /**
     * Add the elapsed argument to the PriorityQueue accessed by the key
     * quersumme.
     * If the key doesn't have a queue, it will be created
     */
    private void addToResults(int quersumme, long elapsed){
        results.putIfAbsent(quersumme, new HashSet<Long>());
        results.get(quersumme).add(elapsed);
    }
    
    public void consume(int n){
        int quersumme = 0;
        long startTimer = System.currentTimeMillis();
        while(n > 0){
           quersumme += n%10;
           n /= 10;
        }
        long elapsedTime = System.currentTimeMillis() - startTimer;
        addToResults(quersumme, startTimer);
    }
    
    public int numberOfDifferentResults(){
        return results.size();
    }
    
    public int numberOfOccurences(int quersumme){
        if(!results.containsKey(quersumme))
            return 0;
        return results.get(quersumme).size();
    }
    
    public PriorityQueue<Long> getCrossTotalsAscending(int quersumme){
        return new PriorityQueue<Long>(
            getTimestampsForResult(quersumme)
        );
    }
    
    public PriorityQueue<Long> getCrossTotalsDescending(int quersumme){
        PriorityQueue<Long> sortedQueue = getCrossTotalsAscending(quersumme);
        PriorityQueue<Long> reversedQueue = new PriorityQueue<>(
                                                   sortedQueue.size(),
                                                   Collections.reverseOrder());
        for(long el: sortedQueue)
            reversedQueue.add(el);
        return reversedQueue;
    }
    
    /**
     * Return the collected timestamps, or an empty HashSet if the quersumme
     * is not in the HashMap
     */
    public HashSet<Long> getTimestampsForResult(int quersumme){
        return results.getOrDefault(quersumme, emptySet);
    }
}
