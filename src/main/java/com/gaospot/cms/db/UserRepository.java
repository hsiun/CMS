package com.gaospot.cms.db;

import java.util.List;

import com.gaospot.cms.domain.Users;

public interface UserRepository {
	
	long count();
	
	Users save(Users users);
	
	Users findOne(long id);
	
	Users findByUsername(String username);
	
	List<Users> findAll();

}
