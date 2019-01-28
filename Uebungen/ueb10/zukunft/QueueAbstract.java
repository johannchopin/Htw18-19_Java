/**
 * Implement generics methods of the Queue
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public abstract class QueueAbstract<T> implements Queue 
{
    protected T[] tab;
    protected int count;
    
    protected QueueAbstract(int size){
        Helpers.checkArgs((size > 0), "Der Groesse muss > 0 sein.");
        this.count = 0;
    }
        
    public T removeFirst(){
        T buffer = this.tab[0];
        ArrayHelpers.removeItem(this.tab, 0);
        this.count--;
        return buffer;
    }
    
    public void addLast(Object o){
        Helpers.checkArgs(isFull(), "The queue is full");
        this.tab[this.count++] = (T)o;
    }
    
    public boolean isEmpty(){
        return this.count == 0;
    }
    
    public boolean isFull(){
        return this.count >= this.tab.length;
    }
    
    public T get(int i){
        return this.tab[i];
    }
    
    public int size(){
        return this.count;
    }
}
