package com.scenario.interview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {
	private Integer id;

	private String firstName;

	private String lastName;

	private Integer Salary;

	public UserModel(String firstName, String lastName, Integer salary) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.Salary = salary;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Salary=" + Salary
				+ "]";
	}

}
