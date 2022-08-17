package com.scenario.interview.docublelock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoublelockImpl implements Doublelock {

	@Autowired
	DoublelockModel getVar;

	@Override
	public void getinput() {
		// TODO Auto-generated method stub

		Thread thone = new Thread(() -> {

			System.out.println(getVar.getInstance());
		});
		Thread thtwo = new Thread(() -> {
			System.out.println(getVar.getInstance());
		});
		Thread thfive = new Thread(() -> {
			System.out.println(getVar.getInstance());
		});
		Thread th6 = new Thread(() -> {
			System.out.println(getVar.getInstance());
		});
		Thread th7 = new Thread(() -> {
			System.out.println(getVar.getInstance());
		});
		thone.start();
		thtwo.start();
		thfive.start();
		th6.start();
		th7.start();
		// return mnm;
	}

}
