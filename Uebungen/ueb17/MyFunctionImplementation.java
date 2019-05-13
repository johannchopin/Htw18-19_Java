package ueb17;

/**
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class MyFunctionImplementation {
	public final static String MAN = 
			"Use : java MyFunctionImplementation [FUNCTION] [START] [END]\n"
			+ "  with \n"
			+ "\t[FUNCTION: String in \"[i|ii|iii|iv]Lambda\" or \"[i|ii|iii|iv]Anon\" or \"iiStatic\"jobs\n"
			+ "\t with\n"
			+ "\t\t i  : f(x) = x*x\n"
			+ "\t\t ii : f(x) = x!\n"
			+ "\t\t iii: f(x) = x^(x-1)\n"
			+ "\t\t iv : f(x) = fib(x) (Fibonacci-Folge)\n"
			+ "\t and\n"
			+ "\t\t Lambda : with lambda expressions implemented\n"
			+ "\t\t Anon : with Anon classes implemented\n"
			+ "\tSTART   : Integer\n"
			+ "\tEND     : Integer\n";

	public static MyFunction iLambda() {
			return (int n) -> n * n;
	}
	
	public static MyFunction iAnon() {
		return new MyFunction() {
			@Override
			public int apply(int i) {
				return i * i;
			}
		};
	}
	
	public static MyFunction iiLambda() {
		return (int n) -> {
			int acc = 1;
			for(int i=2; i <= n; i++)
				acc *= i;
			return acc;
		};
	}
	
	public static MyFunction iiAnon() {
		return new MyFunction() {
			@Override
			public int apply(int n) {
				int acc = 1;
				for(int i=2; i <= n; i++)
					acc *= i;
				return acc;
			}
		};
	}
	
	// Used in iiStatic 
	static class StaticImplemented {
		public static int factorial(int n) {
			int acc = 1;
			for(int i=2; i <= n; i++)
				acc *= i;
			return acc;
		}
	}
	
	// TODO : Check if correct implemented
	public static MyFunction iiStatic() {
		return (int n) -> MyFunctionImplementation.StaticImplemented.factorial(n);
	}
	
	/**
	 * f(x) = x^(x+1)
	 * @param start bound
	 * @param stop bound
	 */
	public static MyFunction iiiLambda() {
		return (int n) -> {
			int acc = n;
			for(int i = 0; i < n; i++)
				acc *= n;
			return acc;
		};
	}
	
	public static MyFunction iiiAnon() {
		return new MyFunction() {
			@Override
			public int apply(int n) {
				int acc = n;
				for(int i = 0; i < n; i++)
					acc *= n;
				return acc;
			}
		};
	}
	
	/**
	 * f(x) = fib(x) (Fibonacci-Folge)

	 * @param start
	 * @param stop
	 */
	public static MyFunction ivLambda() {
		final class Fibo{
			public int[] memoization;
			
			public Fibo(int n) {
				this.memoization = new int[n+1];
			}
			
			public int recurs(int x){
				if(memoization[x] != 0)  // if element is initialized
					return memoization[x];
				
				if(x <= 1)
					memoization[x] = 1;
				else
					memoization[x] = recurs(x - 2) + recurs(x - 1);
				return memoization[x];
			};	
		}
		
		return (int n) -> {return new Fibo(n).recurs(n);};
	}
	
	public static MyFunction ivAnon() {
		return new MyFunction() {
			@Override
			public int apply(int n) {
				
				final class FiboWrapper{
					public int[] memoization;
					
					public FiboWrapper(int n) {
						this.memoization = new int[n+1]; // if 0, the array must have at least 1 case
					}
					
					public int recurs(int x){
						if(this.memoization[x] != 0) // if element is initialized
							return memoization[x];
						if(x <= 1)
							memoization[x] = 1;
						else
							memoization[x] = recurs(x - 2) + recurs(x - 1);
						return memoization[x];
					};
				}
				
				FiboWrapper w = new FiboWrapper(n); // for memoization
				return w.recurs(n);
			}
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
			System.out.println(args.length + " argument(s) found, need " + ARGS_NEEDED + ". See --help.");
			System.exit(1);
		}

		try {
			String method = args[0];
			int start = Integer.parseInt(args[1]);
			int stop = Integer.parseInt(args[2]);
			
			MyFunction f = null;
			switch(method) {
				case "iLambda":
					f = iLambda(); break;
					
				case "iAnon":
					f = iAnon(); break;
					
				case "iiLambda":
					f = iiLambda(); break;
					
				case "iiAnon":
					f = iiAnon(); break;
					
				case "iiStatic":
					f = iiStatic(); break;
					
				case "iiiLambda":
					f = iiiLambda(); break;
				case "iiiAnon":
					f = iiiAnon(); break;
					
				case "ivLambda":
					f = ivLambda(); break;
				case "ivAnon":
					f = ivAnon(); break;

				default:
					System.out.println("Unrecognized method. See --help for available methods.");
					System.exit(1);
			}
			f.applyAndPrint(start, stop);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Wrong input " + e.getMessage().toLowerCase() + ". See --help ");
			System.exit(1);
		}
	}
}