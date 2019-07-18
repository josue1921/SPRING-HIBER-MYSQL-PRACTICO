package com.app.domain.mappers;

import java.util.List;
import com.app.domain.dto.User;
 
public interface UserMapper {

	public void insertUser(User user);
	 
	 public User getUserById(Integer userId);
	 
	 public List<User> getAllUsers();
	 
	 public void updateUser(User user);
	 
	 public void deleteUser(Integer userId);
}
