public class TopLevelFactorial implements MyFunction {
	final static String MAN = "Execute java TopLevelFactorial START END\n"
			+ "  with START and END two integers";
	
	public TopLevelFactorial(int start, int stop) {
		applyAndPrint(start, stop);
	}
	
	@Override
	public int apply(int n) {
		int acc = 1;
		for(int i=2; i <= n; i++)
			acc *= i;
		return acc;
	}
	
	public static void main(String[] args) {
		int ARGS_NEEDED = 2;
		
		if(args.length != ARGS_NEEDED) {
			if(args.length != 0 
			   && (args[0].contentEquals("-h") || args[0].contentEquals("--help"))) {
				System.out.println(MAN);
				System.exit(0);
			}
			System.out.println(args.length + " argument(s) found, need " + ARGS_NEEDED + ".");
			System.exit(1);
		}
		
		try {
			int start = Integer.parseInt(args[0]);
			int stop = Integer.parseInt(args[1]);
			
			new TopLevelFactorial(start, stop);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Wrong input " + e.getMessage().toLowerCase() + ". See --help ");
			System.exit(1);
		}
	}	
}