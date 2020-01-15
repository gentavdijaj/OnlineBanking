package com.userfront.DAO;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.User;

/*
 * CrudRepository - Create, Read and Update
 * Useri edhe Long (ID) ne parameter 
 */

public interface UserDAO extends CrudRepository<User, Long>{
	
	User findByUsername(String name);
	User findByEmail(String email);
}
