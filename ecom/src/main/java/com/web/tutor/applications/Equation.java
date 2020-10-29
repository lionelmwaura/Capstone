package com.web.tutor.applications;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="Equations")
public class Equation {
	
	public Equation() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String math;
	private String equation;
	private String help;
	private String codeEq;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public String getEquation() {
		return equation;
	}
	public void setEquation(String equation) {
		this.equation = equation;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public String getCodeEq() {
		return codeEq;
	}
	public void setCodeEq(String codeEq) {
		this.codeEq = codeEq;
	}
	 
	
	
	
	
}
