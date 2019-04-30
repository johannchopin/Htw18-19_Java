/**
 *    ----> ObjectQueue
 *          --> Implementierung einer ObjectQueue
 *              mittels Object-Array
 *
 * @author      Wolfgang Pauly
 *
 */

public class ObjectQueue 
       implements Queue
{


   public static final int QUEUE_STANDARD_LAENGE = 10;

   private static final String  QUEUE_IST_VOLL = "Die Queue ist vollstaendig belegt !!!";
   private static final String  QUEUE_IST_LEER = "Die Queue ist vollstaendig leer !!!";
   private static final String  INDEX_OUT_OFF_RANGE = "Der angegebene Index ist groesser als die laenge der Queue !";

   // das Queue-Array
   private Object[] queue;
   private int size;


   /** der Konstruktor
    *
    */
   public ObjectQueue() {
       queue = new Object[QUEUE_STANDARD_LAENGE];
       size = 0;
   }


   /** Ein Element an Queue anfuegen
    *
    *  Vorbedingung: !full() 
    */
   public void addLast (Object o) 
   {
     if ( full() )
       {
         throw new RuntimeException(QUEUE_IST_VOLL);
       }
    
     queue[size] = o;
     size++;
   }


   /** Erstes Element aus Queue entfernen
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das Element an der Spitze der Queue
    */
   public Object removeFirst () 
   {
     if ( empty() )
       {
         throw new RuntimeException(QUEUE_IST_LEER);
       }
    
     int i;
     Object helfer = queue[0];
     size--;
     for ( i = 0; i < size; i++ )
       {
        queue[i] = queue[i+1];
       }
     queue[i+1] = null;  
     return helfer;
   }


   /** i'tes Element der Queue zurueckgeben
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das i'te Element der Queue
    */
   public Object get ( int i ) 
   {
     if ( empty() )
       {
         throw new RuntimeException(QUEUE_IST_LEER);
       }
    
     if ( i > size )
       {
         throw new RuntimeException(INDEX_OUT_OFF_RANGE);
       }
    
     return queue[i-1];
   }


   /** Ist die Queue VOLL?      
    *
    * @return true wenn Queue VOLL, sonst false
    */
   public boolean full  () 
   {
     return ( size == 10 );
   }


   /** Ist die Queue LEER?      
    *
    * @return true wenn Queue LEER, sonst false
    */
   public boolean empty  () 
   {
     return ( size == 0 );
   }


   /** Wieviel Elemente enthaelt die Queue?
    *
    * @return Anzahl der Elementen in der Queue
    */
   public int size  () 
   {
     return size;
   }


   /** die Std-Methode toString
    *
    */
   public String toString() 
   {
     StringBuffer sb = new StringBuffer();

     for ( int index = 0; index < size; index++){
           sb.append(queue[index] + " - ");
     }
     return sb.toString();
   }
}
