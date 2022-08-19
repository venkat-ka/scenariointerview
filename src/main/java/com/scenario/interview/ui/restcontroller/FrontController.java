package com.scenario.interview.ui.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.scenario.interview.docublelock.Doublelock;
import com.scenario.interview.entity.UserModel;
import com.scenario.interview.entity.UserRepo;
import com.scenario.interview.entity.UsersEntity;
import com.scenario.interview.immutable.examples.Department;
import com.scenario.interview.immutable.examples.StudentsDetails;
import com.scenario.interview.service.Userservice;

@RestController
public class FrontController {

	@Autowired
	UserRepo repo;

	@Autowired
	Userservice userservice;

	@Autowired
	Doublelock doublelock;

	@GetMapping("/")
	public String getHome() {
		return "UpdateSec Helloworld";
	}

	@GetMapping(path = "/feedrow")
	public ResponseEntity<?> insertRow() {
		UserModel userdetails = new UserModel("Venkat", "Krish", 5000);
		UserModel userdetailsSec = new UserModel("SecVenkat", "Krish", 10923);
		UserModel userdetailsthrd = new UserModel(null, "null check", 10923);
		userservice.createUser(userdetails);
		userservice.createUser(userdetailsSec);
		userservice.createUser(userdetailsthrd);
		return new ResponseEntity<>(userdetails, HttpStatus.OK);
	}
	/* Stream */
	// FloatMap
	// Map, peek, reduce

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<UsersEntity> usr = repo.findById(id);
		if (!usr.isEmpty()) {
			String usename = Optional.ofNullable(usr.get().getFirstName()).orElse("Anonymus");
			String orelseGet = Optional.ofNullable(usr.get().getFirstName())
					.orElseGet(() -> "can be sep fun or Anonymus");

			return new ResponseEntity<>(orelseGet, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sory Anonymus", HttpStatus.OK);
		}
	}

	@GetMapping(path = "/duplicatesalary")
	public ResponseEntity<?> findDupicates() {
		List<UserModel> userlist = userservice.findDuplicatesOneLevel();
		return new ResponseEntity<List<UserModel>>(userlist, HttpStatus.OK);
	}

	@GetMapping(path = "duplicate/{id}/{name}")
	public ResponseEntity<List<HashMap<?, ?>>> findDuplicateCharInNames(@PathVariable Long id,
			@PathVariable String name) {
		List<HashMap<?, ?>> duplicate = userservice.findNameCharDuplicate(id, name);
		return new ResponseEntity<List<HashMap<?, ?>>>(duplicate, HttpStatus.OK);
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<?> getAll() {
		Department dpr = new Department("BCA", "computerblock");
		StudentsDetails imSt = new StudentsDetails("sstn", 33, dpr);
		System.out.println(imSt.toString());
		return new ResponseEntity<List<UsersEntity>>(repo.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/allthread")
	public void getdoubleLock() {
		doublelock.getinput();
	}
}

/*
 * DROP TABLE IF EXISTS TEST; CREATE TABLE TEST(ID INT PRIMARY KEY, NAME
 * VARCHAR(255)); INSERT INTO TEST VALUES(1, 'Hello'); INSERT INTO TEST
 * VALUES(2, 'World'); SELECT * FROM TEST ORDER BY ID; UPDATE TEST SET NAME='Hi'
 * WHERE ID=1; DELETE FROM TEST WHERE ID=2;
 */
