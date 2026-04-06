package com.first;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	int stuid;
	String name;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	double marks;
	public Student() {
		
	}
}
