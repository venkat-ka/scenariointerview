package com.scenario.interview.entity;

import java.util.Comparator;

public class RankComparator implements Comparator<UsersEntity> {

	@Override
	public int compare(UsersEntity o1, UsersEntity o2) {
		// TODO Auto-generated method stub
		if(o1.getId() > o2.getId()) {
			return -1;
		}else if(o1.getId() < o2.getId()) {
			return 1;
		}else {
		return 0;
		}
	}

}
