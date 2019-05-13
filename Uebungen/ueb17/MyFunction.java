import java.lang.FunctionalInterface;

@FunctionalInterface
/**
 * Implement the 1.a Aufgabe
 * 
 * @author Alexandre Guidoux
 * @version 1.0
 */
public interface MyFunction {
	final static int MINIMAL_FOR_POSITIVE_INTEGER =0 ;
	
	public int apply(int i);
	
	/**
	 * 
	 * @param i A bound
	 * @param j A bound
	 * @throws ArithmeticException if the result of apply become negative
	 */
	default void applyAndPrint(MyFunction mf, int i, int j) {
		int start = (i < j)? i: j;
		int stop  = (i > j)? i: j;
		
		checkArgs(start >= 0, "Numbers must be > 0.");
		checkArgs(stop <= Integer.MAX_VALUE, 
					"Number too big for an integer. Must be under " + Integer.MAX_VALUE);
		int result;
		for(int n=start; n <= stop; n++) {
			result = apply(n);
			if(result >= 0)
				System.out.println(result);
			else {
				throw new ArithmeticException(result + ": integer out of bound");
			}
		}
	}
	
	default void applyAndPrint(int i, int j) {
		applyAndPrint(this, i, j);
	}
	
	default void checkArgs(boolean condition, String msg) {
		if(!condition)
			throw new IllegalArgumentException(msg);
	}
}
