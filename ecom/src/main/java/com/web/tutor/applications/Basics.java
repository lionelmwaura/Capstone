package com.web.tutor.applications;

public class Basics {

	public double pow(double base, int power) throws Exception{
		if (base == 0 && power == 0) {
			throw new Exception("0 raised to the 0th power is undefined"); 
		}
		
		return power == 0 ? 1 : power > 0 ? base * pow(base, power -1) : 1.0 / pow(base, power);
	}
	
	public double abs(double n) {
		if(n < 0){
			n = -n;
		}
		return n;
	} 
	
	public double square(double n) {
		return n * n;
	}
	
	public int factorial(int n) throws Exception{
		if (n < 0) {
			throw new Exception("unable to find factorial of negative numbers");
		}
			return n == 0 ? 1 : n * factorial(n - 1);
	}
	
	
}
