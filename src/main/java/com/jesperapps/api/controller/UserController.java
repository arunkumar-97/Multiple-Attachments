package com.jesperapps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.api.message.UserRequestWithProfilePicture;
import com.jesperapps.api.message.UserResponseWithProfilePicture;
import com.jesperapps.api.model.User;
import com.jesperapps.api.service.UserService;



@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/user")
	private ResponseEntity createEmployee(@RequestBody UserRequestWithProfilePicture userRequestWithProfilePicture) {
//		System.out.println(employeeRequest.getEmpoyeeId());
		User createdUser=userService.addUser(userRequestWithProfilePicture);
		if(createdUser != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new UserResponseWithProfilePicture(createdUser));
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new UserResponseWithProfilePicture() );
	
		}
		
	}
}
