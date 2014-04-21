package co.uk.escape.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import co.uk.escape.domain.User;
import co.uk.escape.domain.UserNotFoundException;
import co.uk.escape.domain.UserRepository;
import co.uk.escape.service.UserService;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
class UserRestController {

	@Autowired
	UserService userService;

	// @RequestMapping(method=RequestMethod.GET, value = "/{id}")
	// public User getUser(@PathVariable Long id) {
	// return userService.findOne(id);
	// }

	@RequestMapping(method = RequestMethod.GET, value = "/{username}")
	public User getUser(@PathVariable String username) throws UserNotFoundException {
		return userService.getUserByUsername(username);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findAllUsers();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody User user, UriComponentsBuilder uriBuilder) {
		user = userService.saveUser(user);

		URI uri = uriBuilder.path("/user/{username}").buildAndExpand(user.getUsername()).toUri();

		HttpHeaders headers = new HttpHeaders();

		// uri = linkTo(UserRestController.class).slash(user.getUsername()).toUri()
		headers.setLocation(uri);
		return new ResponseEntity<Void>(null, headers, HttpStatus.CREATED);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<String> handleNotFounds(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	

}
