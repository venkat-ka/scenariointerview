package com.scenario.interview.immutable.examples;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
	public String departmentname;
	public String blockname;

	static Department getInstance(Department department) {
		return new Department(department.getDepartmentname(), department.getBlockname());
	}

	public Department(String departmentname, String blockname) {
		super();
		this.departmentname = departmentname;
		this.blockname = blockname;
	}

	@Override
	public String toString() {
		return "Department [departmentname=" + departmentname + ", blockname=" + blockname + "]";
	}

}
