package PiMath;

public class PiDouble {

	private double Base10;
	private double BasePi;
	private double pi = Math.PI;
	
	// Constructor for empty class instantiation
	public PiDouble() {
		BuildPiDouble();
	}
	
	// Constructor for class instantiation with input
	public PiDouble(double base10Input) {
		BuildPiDouble(base10Input);
	}
	
	
	// Sets variables from no input
	private void BuildPiDouble() {
		Base10 = 0.0;
		BasePi = 0.0;
	}
	
	// Converts a base 10 input to base pi and saves it in the appropriate variable
	// Works by Magic^TM
	// All the meat of the operation happens here.  If it's broken, it's probably in this method
	private void BuildPiDouble(double base10Input) {
		double tempBase10 = base10Input / pi;
		Base10 = base10Input;
		BasePi = 0.0;
		int pow = 0;
		int i = 0;
		
		while (base10Input / Math.pow(pi, pow) > pi)
			pow++;
		
		while (i < 17)
			BasePi += (int)(tempBase10 / Math.pow(pi, pow)) * Math.pow(10, pow);
	}
	
	// String output
	public String toString() {
		return Double.toString(BasePi);
	}
	
	// Math operation methods do the actual math in base-10 before sending the result back to the
	// BuildPiDouble method to convert into Base-pi
	
	// Add two PiDoubles
	public void Add(PiDouble addend) {
		BuildPiDouble(Base10 + addend.Base10);
	}
	
	// Subtract two PiDoubles
	public void Subtract(PiDouble subtrahend) {
		BuildPiDouble(Base10 - subtrahend.Base10);
	}
	
	// Multiply two PiDoubles
	public void Multiply(PiDouble factor) {
		BuildPiDouble(Base10 * factor.Base10);
	}
	
	// Divide two PiDoubles
	public void Divide(PiDouble divisor) {
		BuildPiDouble(Base10 / divisor.Base10);
	}
	
	// Raise a PiDouble to a power using Math.pow
	public void Pow(double power) {
		BuildPiDouble(Math.pow(Base10, power));
	}
	
	// Raise a PiDouble to a power by repeated multiplication
	// Should be faster than using Math.pow with integer powers
	public void Pow(int power) {
		double temp = Base10;
		for (int i = 0; i < power; i++) 
			Base10 *= temp;
		BuildPiDouble(Base10);
	}
	
	
	// Getter for Base Pi number
	public double getBasePi() {
		return BasePi;
	}
	
	// Getter for Base 10 number
	public double getBase10() {
		return Base10;
	}
}
