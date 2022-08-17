package com.scenario.interview.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UsersEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5373601101179260733L;
	@Id
	@GeneratedValue
	private long id;

	@Column(length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(length = 50)
	private Integer Salary;

	@Override
	public String toString() {
		return "UsersEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Salary=" + Salary
				+ "]";
	}

}

/*
 * INSERT INTO USERS VALUES(1, 'mm', 'World');
 */
