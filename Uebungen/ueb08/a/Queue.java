import java.lang.StringBuilder;
/**
 * A simple Queue
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Queue<T>
{
    public T[] array;
    public int count;
    
    private final static String MIN_SIZE_ERROR = 
                                "Der Groesse muss > 0 sein. Abbruch";
    private final static String QUEUE_SIZE_ERROR = 
                                "Die Warteschlange ist voll. Abbruch.";
    private final static String EMPTY_QUEUE_ERROR = 
                                "Die Warteschlange ist leer. Abbruch";
    private final static String INDEX_OUT_OF_BOUNDS_ERROR =
                                "Der Index ist zu gross";
    
    Queue(int size){
        FuncHelpers.checkArguments(size > 0, MIN_SIZE_ERROR);
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size];
        this.array = array;
        this.count = 0;
    }
    
    private void shift(int i){
         while(i <= this.count)
            this.array[i] = this.array[++i];
    }
    
    public int length(){
        return this.array.length;
    }
    public int getCount(){
        return this.count;
    }
    
    public void add(T element){
        FuncHelpers.checkIndexBounds(this.count <= this.array.length-1,
                                     QUEUE_SIZE_ERROR);
        this.array[this.count++] = element;
    }
    
    public T remove(int i){
        FuncHelpers.checkIndexBounds(this.array[i] != null, EMPTY_QUEUE_ERROR); 
        FuncHelpers.checkIndexBounds(i < this.count, INDEX_OUT_OF_BOUNDS_ERROR);
        T element = this.array[i];
        shift(i);
        return element;
    }
    public T pop(){
        return remove(0);
    } 
    
    public String toString(String header){
        StringBuilder str = new StringBuilder(header);
        for(int i=0; i < this.count; i++)
            str.append(this.array[i].toString());
        str.trimToSize();
        return str.toString();
    }
    public String toString(){
        return this.toString("");
    }
}
