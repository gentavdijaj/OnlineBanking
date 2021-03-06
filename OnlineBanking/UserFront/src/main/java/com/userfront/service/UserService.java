package com.userfront.service;

import com.userfront.domain.User;

public interface UserService {
	
	User findByUsername(String username);
	User findByEmail(String email);
	
	boolean checkUserExists(String username, String email);
	boolean checkExistingUsername(String username);
	boolean checkExistingMail(String email);
	
	void saveUser(User user);

}
