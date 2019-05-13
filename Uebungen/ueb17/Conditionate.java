package ueb17;

import java.util.function.IntPredicate;


public interface Conditionate extends MyFunction {
	
	/**
	 * @param predicate
	 * @return an implementation of MyFunction
	 */
	default Conditionate conditionateInput(IntPredicate predicate) {
		return (int n) -> {
			if(predicate.test(n))
				return apply(n);
			return 0;
		};
	}
	
	default Conditionate conditionateOutput(IntPredicate predicate) {
		return (int n) -> {
			int result = apply(n);
			if(predicate.test(result))
				return result;
			return 0;
		};
	}
}
