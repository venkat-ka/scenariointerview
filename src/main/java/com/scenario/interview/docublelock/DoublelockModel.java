package com.scenario.interview.docublelock;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class DoublelockModel {
	private volatile static DoublelockModel checkValue;

	private DoublelockModel() {

	}

	public DoublelockModel getInstance() {
		if (checkValue == null) {
			synchronized (DoublelockModel.class) {
				if (checkValue == null) {
					System.out.println("in");
					checkValue = new DoublelockModel();
				}
			}
		}
		return checkValue;
	}

	public DoublelockModel getInputInModel() {
		System.out.println(checkValue + " ==<>==");
		return checkValue;
	}
}
