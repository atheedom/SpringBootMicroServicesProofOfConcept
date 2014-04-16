package org.microservices.control;

import org.microservices.entity.User;
import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Long>{

	//User findOne(Long id);

}
