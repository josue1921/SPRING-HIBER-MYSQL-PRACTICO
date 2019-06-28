package sytcom.springboot.app.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sytcom.springboot.app.springsecurity.model.User;
import sytcom.springboot.app.springsecurity.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
