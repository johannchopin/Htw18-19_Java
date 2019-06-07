import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * A test class for the DoubleLinkedList data structure
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class DoubleLinkedListTest
{
    public static String printList(DoubleLinkedList l){
        Iterator it = l.iterator();
        String acc = "";
        while(it.hasNext())
            acc += it.next() + ", ";
        return acc + "\n";
    }

    public static int testSize(DoubleLinkedList l){
        int count= 0;
        for(Iterator it = l.iterator() ; it.hasNext(); it.next())
            count++;
        return count;
    }
    
    public static void main(String[] main){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.print("Initial List: " + printList(list));

        System.out.println("contains(1): " + list.contains(1));
        System.out.println("contains(42): " + list.contains(42));

        Integer[] arr = list.toArray(new Integer[list.size()]);
        System.out.print("toArray(new Integer[list.size()]): ");
        for(int n: arr)
            System.out.print(n + ", ");
        System.out.println();

        list.remove(1);
        System.out.print("remove(1): " + printList(list));

        System.out.println("get(1): " + list.get(1));
        System.out.println("get(0): " + list.get(0));
        System.out.println("get(4): " + list.get(4));

        list.set(1, 42);
        System.out.print("set(1, 42): " + printList(list));
        System.out.println("contains(42): " + list.contains(42));

        list.add(0, 0);
        System.out.print("add(0,0): " + printList(list));
        list.add(3, 80);
        System.out.print("add(3, 80): " + printList(list));

        System.out.println("get(3): " + list.get(3));

        System.out.println("indexOf(42): " + list.indexOf(42));
        System.out.println("Remove index 1: " + list.remove((int) 1));
        System.out.print("List: " + printList(list));
        
        LinkedList<Integer> linked = new LinkedList<Integer>();
        linked.add(50); linked.add(51); linked.add(52);
        list.addAll(linked);
        System.out.print("Added a linkedList (50,51,52) : " + printList(list));
        
        System.out.println("----------ListIterator----------");
        ListIterator<Integer> fullIt = list.listIterator();
        System.out.println("ListIterator at index 6: " + fullIt.next());
        System.out.println("hasPrevious(): " + fullIt.hasPrevious());
        if(fullIt.hasPrevious())
            System.out.println("previous(): " + fullIt.previous());
        System.out.println("hasNext(): " + fullIt.hasNext());
        if(fullIt.hasNext())
            System.out.println("next() : " + fullIt.next());
            
        fullIt.add(100);
        System.out.print("add(100) via listIterator: " + printList(list));
        if(!fullIt.hasNext())
            System.out.println("Link broken");
        System.out.println("add(100) using next to print: " + fullIt.previous());
        System.out.println("The value after the insertion is: " + fullIt.next());
    }
}
