package co.uk.escape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.uk.escape.domain.User;
import co.uk.escape.domain.UserNotFoundException;
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

	public User getUserByUsername(String username) throws UserNotFoundException{
		
		User user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UserNotFoundException();
		}
		
		return userRepository.findByUsername(username);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
