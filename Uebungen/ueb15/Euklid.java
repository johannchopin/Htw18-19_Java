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
}
