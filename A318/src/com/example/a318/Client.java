package com.example.a318;

import java.io.Serializable;

public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8469117362319059147L;
	private String name;
	private int age;
	private boolean sex;
	
	public Client(String name, int age, boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isSex() {
		return this.sex;
	}
	
	@Override
	public String toString() {
		return this.name + " of age " + this.age + " and of sex: " + (this.sex ? "male" : "female");
	}
	
}
