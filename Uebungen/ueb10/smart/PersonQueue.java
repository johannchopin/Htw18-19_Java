
/**
 * A simple Queue of Person
 *
 * @author Alexandre Guidoux
 * @version 2.0
 */
public class PersonQueue extends QueueAbstract
{
    private Person[] tab;
    
    PersonQueue(int size){
        super(size);
        this.tab = new Person[size];
    }
        
    public Person removeFirst(){
        Person buffer = this.tab[0];
        ArrayHelpers.removeItem(this.tab, 0);
        this.count--;
        return buffer;
    }
    
    public void addLast(Object o){
        Helpers.checkArgs((o instanceof Person), "Argument must be a Person");
        Helpers.checkArgs(isFull(), "The queue is full");
        this.tab[this.count++] = (Person)o;
    }
    
    public Person get(int i){
        return this.tab[i];
    }
}
