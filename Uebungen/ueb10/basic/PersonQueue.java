
/**
 * A simple Queue of Person
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class PersonQueue implements Queue
{
    private Person[] tab;
    private int count;
    
    PersonQueue(int size){
        Helpers.checkArgs((size > 0), "Der Groesse muss > 0 sein.");
        this.tab   = new Person[size];
        this.count = 0;
    }
        
    public Person removeFirst(){
        Helpers.checkArgs(!(isEmpty()), "Der Queue ist leer !");
        Person buffer = this.tab[0];
        ArrayHelpers.removeItem(this.tab, 0);
        this.count--;
        return buffer;
    }
    
    public void addLast(Object o){
        Helpers.checkArgs((o instanceof Person), "Argument must be a Person");
        Helpers.checkArgs(!(isFull()), "The queue is full");
        this.tab[this.count++] = (Person)o;
    }
    
    public boolean isEmpty(){
        return this.count == 0;
    }
    
    public boolean isFull(){
        return this.count >= this.tab.length;
    }
    
    public String get(int i){
        Helpers.checkArgs((1 <= i) && (i <= size()), 
                          "IndexOutOfBound im Queue");
        return this.tab[i-1].toString();
    }
    
    public int size(){
        return this.count;
    }
}
