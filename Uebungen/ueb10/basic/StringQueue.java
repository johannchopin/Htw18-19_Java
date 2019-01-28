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
    
    /**
     * Schafft ein Queue mit einem bestimmten size
     */
    StringQueue(int size){
        Helpers.checkArgs((size > 0), "Der Groesse muss > 0 sein.");
        this.tab   = new String[size];
        this.count = 0;
    }
    
    /**
     * Loescht das erste Objekt des Queue und gib das Objekt zurueck
     */
    public String removeFirst(){
        Helpers.checkArgs(!(isEmpty()), "Der Queue ist leer !");
        String buffer = this.tab[0];
        ArrayHelpers.removeItem(this.tab, 0);
        this.count--;
        return buffer;
    }
    
    /**
     * Fuege ein Objekt am Ende des Queue
     * @param o hinzuzufuegen
     */
    public void addLast(Object o){
        Helpers.checkArgs((o instanceof String), "Argument must be a String");
        Helpers.checkArgs(!(isFull()), "The queue is full");
        this.tab[this.count++] = (String)o;
    }
    
    /**
     * Ueberprueft, wenn der Queue leer ist
     */
    public boolean isEmpty(){
        return this.count == 0;
    }
    
    /**
     * Ueberprueft, wenn der Queue voll ist
     */
    public boolean isFull(){
        return this.count == this.tab.length;
    }
    
    /**
     * Gib der i-te Element zurueck
     */
    public String get(int i){
        Helpers.checkArgs((1 <= i) && (i <= size()), 
                          "IndexOutOfBound im Queue");
        return this.tab[i-1];
    }
    
    /**
     * Gib der gegenwaertige Zahl der gesamten Objekten im Queue zurueck
     */
    public int size(){
        return this.count;
    }
}
