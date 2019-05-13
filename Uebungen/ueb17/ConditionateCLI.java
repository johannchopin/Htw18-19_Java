import java.util.function.IntPredicate;

public class ConditionateCLI {
    public static final String MAN = "";

    public static Conditionate iLambdaConditionate() {
        return (int n) -> n * n;
    }
    
    public static Conditionate iiLambda() {
        return (int n) -> {
            int acc = 1;
            for(int i=2; i <= n; i++)
                acc *= i;
            return acc;
        };
    }
    
    public static void main(String[] args) {
        int ARGS_NEEDED = 3;
        
        if(args.length != ARGS_NEEDED) {
            if(args.length != 0 
               && (args[0].contentEquals("-h") || args[0].contentEquals("--help"))) {
                System.out.println(MAN);
                System.exit(0);
            }
            System.out.println(args.length + " argument(s) found, need " + ARGS_NEEDED + ".");
            System.exit(1);
        }

        // MAIN CODE IMPLEMENTATION
        IntPredicate isEven = (int n) -> n%2 == 0;
        IntPredicate isOdd = new IntPredicate() {
            public boolean test(int n) {
                return !isEven.test(n);
            }
        };
        
        Conditionate isEvenSquareNumber = ConditionateCLI.iLambdaConditionate()
                                            .conditionateInput(isEven);
                                               Conditionate isOddFactorialNumber = ConditionateCLI.iiLambda()
                                            .conditionateOutput(isOdd);
       // END CODE IMPLEMENTATION
       
       
       
        try {
            String method = args[0];
            int start = Integer.parseInt(args[1]);
            int stop = Integer.parseInt(args[2]);
            
            Conditionate c = null;
            switch(method) {
                case "EvenSquareNumber":
                    c = isEvenSquareNumber; break;
                    
                case "OddFactorialNumber":
                    c = isOddFactorialNumber; break;
                
                default:
                    System.out.println("Unrecognized method. See --help for available methods.");
                    System.exit(1);
            }
            c.applyAndPrint(start, stop);
        } catch(NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Wrong input " + e.getMessage().toLowerCase() + ". See --help ");
            System.exit(1);
        }
    }
}
