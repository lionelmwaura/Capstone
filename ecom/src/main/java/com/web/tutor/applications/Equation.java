package com.web.tutor.applications;

import java.util.ArrayList;

public class Equation {

	public Equation() {
	}
	
	private String math;
	private ArrayList<Double> input;
	private ArrayList<String> arithmetic;
	
	
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public ArrayList<Double> getInput() {
		return input;
	}
	public void setInput(ArrayList<Double>input) {
		this.input = input;
	}
	public ArrayList<String> getArithmetic() {
		return arithmetic;
	}
	public void setArithmetic(ArrayList<String> arithmetic) {
		this.arithmetic = arithmetic;
	}
}
