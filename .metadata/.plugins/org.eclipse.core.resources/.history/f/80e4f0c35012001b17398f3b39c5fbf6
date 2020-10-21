package com.web.tutor.applications;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="algebra")
public class Algebra {
	
	public Algebra() {
	}
	
	private ArrayList<Equation> equations;

	public ArrayList<Equation> getEquations() {
		return equations;
	}
	public void setEquations(ArrayList<Equation> equations) {
		this.equations = equations;
	}
	
	public static double solution(Equation eq) {
		//Initialize solution
		double solution = 0;
		
		ArrayList<Double> input = eq.getInput();
		ArrayList<String> arithmetic = eq.getArithmetic();
		
		for(int i = 0; i < input.size(); i++) {
			if(i == 0) {
				solution = input.get(i);
			}else if(arithmetic.get(i - 1) == "+") {
				solution = solution + input.get(i);
			} else if (arithmetic.get(i - 1) == "-") {
				solution = solution - input.get(i);
			} else if (arithmetic.get(i - 1) == "*") {
				solution = solution * input.get(i);
			} else if (arithmetic.get(i - 1) == "/") {
				solution = solution / input.get(i);
			} 
		}
		
		return solution;
	}
	
	
	
}
