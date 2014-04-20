package co.uk.escape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.uk.escape.domain.User;
import co.uk.escape.domain.UserRepository;

@Service
public class UserService {	
	
	UserRepository userRepository;
	
	public UserService(){}
	
	@Autowired
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}
}
