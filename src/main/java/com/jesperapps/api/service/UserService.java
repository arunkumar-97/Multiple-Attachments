package com.jesperapps.api.service;

import com.jesperapps.api.message.UserRequestWithProfilePicture;
import com.jesperapps.api.model.User;


public interface UserService {
	
//	User findByUserEmail(String userEmail);
	
	User findById(int userId);
	
	User addUser(UserRequestWithProfilePicture userRequestWithProfilePicture);

}
