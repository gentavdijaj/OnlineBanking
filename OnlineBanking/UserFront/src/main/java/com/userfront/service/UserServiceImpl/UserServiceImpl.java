package com.userfront.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userfront.DAO.UserDAO;
import com.userfront.domain.User;
import com.userfront.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	/*
	 * The @Autowired annotation spares you the need to do the wiring 
	 * by yourself in the XML file (or any other way) and just finds 
	 * for you what needs to be injected where, and does that for you.
	 */
	@Autowired
	private UserDAO userDao;
	
	public void saveUser(User useri) {
		userDao.save(useri);
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public boolean checkUserExists(String emri, String email) {
		if(checkExistingUsername(emri) || checkExistingMail(email)) {
			return true;
		}
		return false;
	}
	public boolean checkExistingUsername(String name) {
		if(findByUsername(name) != null) {
			return true;
		}
		return false;
	}
	
	public boolean checkExistingMail(String mail) {
		if(findByEmail(mail) != null) {
			return true;
		}
		return false;
	}

	
}
