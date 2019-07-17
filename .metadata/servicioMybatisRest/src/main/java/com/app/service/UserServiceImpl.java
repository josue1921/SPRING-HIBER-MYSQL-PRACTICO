package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.app.dao.UserDao;  
import com.app.domain.User;  

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User selectUserById(Integer userId) {
		return userDao.selectUserById(userId);
	}
}
