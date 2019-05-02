import java.util.Comparator;

/**
 * Simulate an element in a array. That is to say a value with an index.
 * 
 * @author Alexandre Guidoux
 * @version 1.0
 */
class ArrayElement 
          implements Comparator<ArrayElement>, Comparable<ArrayElement> {
    int   index;
    float value;
    
    ArrayElement(int index, float value){
        this.index = index;
        this.value = value;
    }
    
    public int compare(ArrayElement el1, ArrayElement el2){
        return Float.compare(el1.value, el2.value);
    }
    
    @Override
    public int compareTo(ArrayElement other){
        return compare(this, other); // Because already implemented
    }
}