
/**
 * A simple Queue of Strings
 *
 * @author Alexandre Guidoux
 * @version 2.0
 */
public class StringQueue extends QueueAbstract
{
    private String[] tab;
    private int count;
    
    StringQueue(int size){
        super(size);
        this.tab = new String[size];
    }
        
    public String removeFirst(){
        String buffer = this.tab[0];
        ArrayHelpers.removeItem(this.tab, 0);
        this.count--;
        return buffer;
    }
    
    public void addLast(Object o){
        Helpers.checkArgs((o instanceof String), "Argument must be a String");
        Helpers.checkArgs(isFull(), "The queue is full");
        this.tab[this.count++] = (String)o;
    }
    
    public String get(int i){
        return this.tab[i];
    }
}
