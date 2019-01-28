/**
 * Simple Queue with Strings
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class StringQueue extends QueueAbstract
{
    public StringQueue(int size){
        super(size);
        super.tab = new String[size];
    }
    
    public void addLast(Object o){
        Helpers.checkArgs((o instanceof String), "The given object must be a string");
        super.addLast(o);
    }
}