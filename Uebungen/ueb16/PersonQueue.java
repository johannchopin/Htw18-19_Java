import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *    ----> PersonQueue
 *          --> Implementierung einer PersonQueue
 *              mittels der allgemeinen ObjectQueue
 *
 * @author      Wolfgang Pauly
 *
 */

public class PersonQueue extends ObjectQueue implements Iterable<Person>
{
   private static final String  KEIN_PERSON_OBJEKT = "Das einzufuegende Objekt ist KEIN Person-Objekt !!";


   /** Ein Person-Element an Queue anfuegen
    *
    *  Vorbedingung: !full() 
    */
   @Override
   public void addLast (Object o) 
   {
     if ( o instanceof Person )
        super.addLast( o );
     else
        throw new RuntimeException(KEIN_PERSON_OBJEKT);
   }


   /** Erstes Element aus Queue entfernen
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das Person-Element an der Spitze der Queue
    */
   @Override
   public Person removeFirst () {
       return (Person)super.removeFirst();
   }


   /** i'tes Element der Queue zurueckgeben
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das i'te Element der Queue
    */
   @Override
   public Person get ( int i ) {
       return (Person)super.get(i);
   }

   /**
    * A simple iterator for the queue. Begin at the head of the queue 
    * (index 0) and end with the last added Person
    */
   private class PersonIterator implements Iterator<Person>{
       int i = 1; // First element in the queue
       
       @Override
       public boolean hasNext() {
           return i <= size();
       }
       
       /*
        * @return the next Person
        * @throws NoSuchElementException when the iterator has iterated over the PersonQueue
        */
       @Override
       public Person next() {
           if(!hasNext())
               throw new NoSuchElementException();
           return get(i++);
        }
   }
   
   /**
    * Implement the Iterable interface
    */
   public Iterator<Person> iterator(){
       return new PersonIterator();
   }
   
   /**
    * Print the string representation of the person in 
    * the queue, separated with "-"
    */
   public void print(){
       for(Person p: this)
            System.out.print(p + " -> ");
       System.out.println();
   }
   
   /**
    * @return the lexicographically shortest Vorname in the Queue
    */
   public String smallest(){
       String vorname;
       if(size() == 0)
            return "";
                          // Init string with the first value
       String bestSoFar = this.get(1).getVorname();
       for(Person p: this){
           vorname = p.getVorname();
           if(vorname.compareToIgnoreCase(bestSoFar) < 0)
                bestSoFar = vorname;
       }
       return bestSoFar;
   }
   
   public static void main(String[] args){
       PersonQueue q = new PersonQueue();
       q.addLast(new Person("Guidoux", "Alexandre"));
       q.addLast(new Person("Guidoux", "Fabrice"));
       q.addLast(new Person("Guidoux", "Aurore"));
       System.out.println("Smallest: " + q.smallest());
       System.out.print("Queue : ");
       q.print();
   }
}
