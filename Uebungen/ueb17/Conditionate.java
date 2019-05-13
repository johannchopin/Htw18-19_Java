import java.util.function.IntPredicate;

/**
 * Extends the MyFunction interface with 2 filter methods.
 * They filter apply or the argument with a predicate 
 * and create a new object Conditionate
 */
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
