/**
 * Simple Queue of Person
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class PersonQueue extends QueueAbstract
{    
    public PersonQueue(int size){
        super(size);
        super.tab = new Person[size];
    }
    
    public void addLast(Object o){
        Helpers.checkArgs((o instanceof Person), "The given object must be a Person");
        super.addLast(o);
    }
}
