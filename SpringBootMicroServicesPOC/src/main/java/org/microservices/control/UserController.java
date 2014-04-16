package org.microservices.control;

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
class UserController {

  @Autowired
  UserRepository repository;

  @RequestMapping(method=RequestMethod.GET, value = "/{id}")
  public User get(@PathVariable Long id) {
    return repository.findOne(id);
  }
  

  @RequestMapping(method=RequestMethod.POST)
  public void create(@RequestBody User user){
	  repository.save(user);
  }

}
