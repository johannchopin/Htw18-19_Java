/**
 * An abstract class of the Queue for the generic methods.
 * Need to implement addLast(), removeFirst(), get() and array initialization
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public abstract class QueueAbstract implements Queue
{
    protected int count;
    protected int size;

    QueueAbstract(int size){
        Helpers.checkArgs((size > 0), "Der Groesse muss > 0 sein.");
        this.count = 0;
    }
    
    public boolean isEmpty(){
        return this.count == 0;
    }
    
    public boolean isFull(){
        return this.count == this.size;
    }
    
    public int size(){
        return this.count;
    }
}
