package com.app.service;

import java.util.List;

import com.app.entity.User;

public interface UserService {


	List<User> findAllUser();
	
	void update(User user);
	void update(String id);
	void save(User user);
	void delete(String id);
}
