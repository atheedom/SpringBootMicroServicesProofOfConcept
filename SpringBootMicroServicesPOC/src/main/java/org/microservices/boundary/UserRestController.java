package org.microservices.boundary;

import java.util.List;

import org.microservices.control.UserRepository;
import org.microservices.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
class UserRestController {

  @Autowired
  UserService userService;

//  @RequestMapping(method=RequestMethod.GET, value = "/{id}")
//  public User getUser(@PathVariable Long id) {
//    return userService.findOne(id);
//  }
  
  @RequestMapping(method=RequestMethod.GET, value = "/{username}")
  public User getUser(@PathVariable String username) {
    return userService.findOne(username);
  }
  
  @RequestMapping(method=RequestMethod.GET)
  public List<User> getUsers() {
    return userService.findAllUsers();
  }

  @RequestMapping(method=RequestMethod.POST)
  public void addUser(@RequestBody User user){
	  userService.saveUser(user);
  }
  
}