package com.app.domain.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.domain.dto.User;
import com.app.domain.mappers.UserMapper;

@Service
@Transactional
public class UserService {

	@Autowired
    private SqlSession sqlSession; //This is to demonstrate injecting SqlSession object
 
	
	public void insertUser(User user) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUser(user);
	}

	public User getUserById(Integer userId) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getUserById(userId);
	}

	public List<User> getAllUsers() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getAllUsers();
	}

	public void updateUser(User user) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.updateUser(user);

	}

	public void deleteUser(Integer userId) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUser(userId);

	}

}
