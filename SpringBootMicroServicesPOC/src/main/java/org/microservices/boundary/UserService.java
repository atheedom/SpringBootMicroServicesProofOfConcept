package org.microservices.boundary;

import java.util.List;

import org.microservices.control.UserRepository;
import org.microservices.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {	
	
	UserRepository userRepository;
	
	public UserService(){}
	
	@Autowired
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	public User findOne(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}
}
