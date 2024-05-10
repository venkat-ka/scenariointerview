package com.scenario.interview.immutable.examples;

import lombok.Getter;

@Getter
final public class StudentsDetails {
	final String name;
	final Integer marks;
	final Department department;

	public StudentsDetails(String name, Integer marks, Department department) {
		super();
		this.name = name;
		this.marks = marks;
		this.department = department;
	}

	public Department getDepartment() {
		// this statement will make a immutable as like
		return Department.getInstance(department);
	}

	@Override
	public String toString() {
		return "StudentsDetails [name=" + name + ", marks=" + marks + ", department=" + department + "]";
	}

}

/* Rules for immutable class 
 * class will public final
 * field constructor will be public and no final
 * class fields will be private final.
 */
