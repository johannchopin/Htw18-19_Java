public class Euklid {
	private int n1;
	private int n2;
	
	public Euklid(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public int rechnen() {
		return rechnen(this.n1, this.n2);
	}
	
	public static int rechnen(int n1, int n2) {
		if (n2 == 0)
			return n1;
		return rechnen(n2, n1 % n2);
	}
	
	public int getN1() {
		return this.n1;
	}
	
	public int getN2() {
		return this.n2;
	}

    public static void main(String[] args){
        if(args.length != 2)
            throw new IllegalArgumentException("2 arguments must be provided, not " + args.length);
        try{
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            System.out.println(rechnen(n1, n2));
        } catch (NumberFormatException e){
            System.out.println(e + ". Must be two integers.");
        }
    }
}
