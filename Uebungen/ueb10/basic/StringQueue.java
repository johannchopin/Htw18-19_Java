/**
 * A simple Queue of Strings
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class StringQueue implements Queue
{
    private String[] tab;
    private int count;
    
    StringQueue(int size){
        Helpers.checkArgs((size > 0), "Der Groesse muss > 0 sein.");
        this.tab   = new String[size];
        this.count = 0;
    }
        
    public String removeFirst(){
        Helpers.checkArgs(!(isEmpty()), "Der Queue ist leer !");
        String buffer = this.tab[0];
        ArrayHelpers.removeItem(this.tab, 0);
        this.count--;
        return buffer;
    }
    
    public void addLast(Object o){
        Helpers.checkArgs((o instanceof String), "Argument must be a String");
        Helpers.checkArgs(!(isFull()), "The queue is full");
        this.tab[this.count++] = (String)o;
    }
    
    public boolean isEmpty(){
        return this.count == 0;
    }
    
    public boolean isFull(){
        return this.count == this.tab.length;
    }
    
    public String get(int i){
        Helpers.checkArgs((1 <= i) && (i <= size()), 
                          "IndexOutOfBound im Queue");
        return this.tab[i-1];
    }
    
    public int size(){
        return this.count;
    }
}
