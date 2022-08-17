package com.scenario.interview.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scenario.interview.entity.UserModel;
import com.scenario.interview.entity.UserRepo;
import com.scenario.interview.entity.UsersEntity;

@Service
public class UserServiceImpl implements Userservice {

	@Autowired
	UserRepo userRepo;

//	public UserServiceImpl(UserRepo userRepo) {
//
//		this.userRepo = userRepo;
//	}

	@Override
	public UserModel createUser(UserModel userDetails) {
		// Pull ModelMapper

		// ModelMapper configuration
		ModelMapper userModel = new ModelMapper();
		userModel.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		// Call EntityClass type with assign UserModel map method
		UsersEntity userentity = userModel.map(userDetails, UsersEntity.class);
		// Save to repo
		userRepo.save(userentity);
		UserModel userRes = userModel.map(userentity, UserModel.class);
		return userRes;
	}

	public List<UserModel> findDuplicatesOneLevel() {
		List<UserModel> userDetils = new ArrayList<UserModel>();
		List<UsersEntity> userenty = userRepo.findAll().stream().collect(Collectors.toList());
		Set<Integer> UniqueSalay = new HashSet<Integer>();
		Set<UsersEntity> usrEnty = userenty.stream().filter(e -> !UniqueSalay.add(e.getSalary()))
				// .map(e -> e.getSalary())
				// .filter(e -> )
				.collect(Collectors.toSet());
		System.out.println(UniqueSalay);
		ModelMapper userModel = new ModelMapper();
		userModel.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		// UserModel userModelMap = userModel.map(userenty, UserModel.class);
		usrEnty.forEach(user -> userDetils.add(userModel.map(user, UserModel.class)));
		// students.forEach(student -> dtos.add(mapper.map(student, StudentDto.class)));
		// System.out.println(userDetils);
		// https://www.amitph.com/java-lists-modelmapper/
		// userDetils.add(userModelMap);
		// List<userModelMap> us = System.out.println(userDetils);
		return userDetils;
	}

	@Override
	public List<HashMap<?, ?>> findNameCharDuplicate(Long id, String name) {
		// TODO Auto-generated method stub
		List<HashMap<?, ?>> prepareRest = new ArrayList<HashMap<?, ?>>();
		HashMap<Integer, String> fullString = new HashMap<Integer, String>();

		HashMap<Character, Integer> onlyDup = new HashMap<Character, Integer>();
		prepareRest.add(fullString);

		try {
			Optional<UsersEntity> userObj = userRepo.findById(id);
			String userName = name == "lastName" ? userObj.get().getLastName() : userObj.get().getFirstName();
			fullString.put(1, userName + " = This Approach o(n) instead of o(n2)");
			// Set<Character> duplicate = new LinkedHashSet<>();
			HashMap<Character, Integer> countDuplicate = new HashMap<Character, Integer>();
// 			This Approach o(n) instead of o(n2)
			for (int i = 0; i < userName.length(); i++) {
				if (countDuplicate.containsKey(userName.charAt(i))) {
					countDuplicate.put(userName.charAt(i), countDuplicate.get(userName.charAt(i)) + 1);
				} else {
					countDuplicate.put(userName.charAt(i), 1);
				}
			}
			for (Map.Entry<Character, Integer> insrtOnlyDup : countDuplicate.entrySet()) {
				if (insrtOnlyDup.getValue() > 1) {
					onlyDup.put(insrtOnlyDup.getKey(), insrtOnlyDup.getValue());
				}
			}
			prepareRest.add(onlyDup);
		} catch (Exception e) {
			System.out.println(e);
			// onlyDup,put("No Data found", 1);
		}
		return prepareRest;
	}

}
