package com.app.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.entity.User;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.findByList(new HashMap<String, Object>());
	}
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		User u = userDao.findById(user.getId());
		u.setName(user.getName());
		u.setPwd(user.getPwd());
		userDao.update(u);
	}
	
	@Override
	public void update(String id) {
		// TODO Auto-generated method stub
		User u = userDao.findById(id);
		u.setName("demo_" + u.getName());
		u.setPwd("demo_" +u.getPwd());
		userDao.update(u);
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		User u = userDao.findById(id);
		userDao.delete(u);
	}

}
