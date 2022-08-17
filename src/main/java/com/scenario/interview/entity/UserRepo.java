package com.scenario.interview.entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UsersEntity, Long> {
	UsersEntity findById(long id);

	List<UsersEntity> findAll();

	// UsersEntity saveRow(UsersEntity data);
}
