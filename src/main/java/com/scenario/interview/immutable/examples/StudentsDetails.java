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
		return Department.getInstance(department);
	}

	@Override
	public String toString() {
		return "StudentsDetails [name=" + name + ", marks=" + marks + ", department=" + department + "]";
	}

}
