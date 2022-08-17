package com.scenario.interview.service;

import java.util.HashMap;
import java.util.List;

import com.scenario.interview.entity.UserModel;

public interface Userservice {
	UserModel createUser(UserModel userdetails);

	List<UserModel> findDuplicatesOneLevel();

	List<HashMap<?, ?>> findNameCharDuplicate(Long id, String name);

}
