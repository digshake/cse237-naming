package naming.exercises;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(int n, int b) {
		this.numerator = n;
		this.denominator = b;
	}
	
	public Fraction add(Fraction nt) {
		int nb = this.denominator * nt.denominator;
		int nTop = this.denominator * nt.numerator + this.numerator * nt.denominator;
		
		return new Fraction(nTop, nb);
	}
	
	public Fraction multiply(Fraction nt) {
		int poop = this.numerator * nt.numerator;
		int haha = this.denominator * nt.denominator;
		
		return new Fraction(poop, haha);
	}
	
	public Fraction upsideDown() {
		return new Fraction(this.denominator, this.numerator);
	}
	
	public Fraction makeSimple() {
		int f = Fraction.gcd(this.numerator, this.denominator);
		return new Fraction(this.numerator / f, this.denominator / f);
	}
	
	public String toString() {
		return this.numerator + " / " + this.denominator;
	}
	
	/**
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		while (q != 0) {
			int temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}
	
	
	
	public static void main(String[] args) {
		Fraction one = new Fraction(1, 2);
		Fraction two = new Fraction(3, 4);
		
		Fraction three = one.add(two);
		Fraction four = two.add(one);
		
		System.out.println(four);
		
		Fraction five = two.multiply(one);
		
		System.out.println(five);
		
		Fraction six = three.makeSimple();
		System.out.println(six);
	}

}
