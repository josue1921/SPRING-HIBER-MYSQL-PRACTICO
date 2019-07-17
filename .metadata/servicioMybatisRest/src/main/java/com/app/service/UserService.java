package com.app.service;
import com.app.domain.User;

public interface UserService {
	User selectUserById(Integer userid);
}
