package com.zycus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zycus.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("select u from User u where u.username = :username and u.password = :password")
	public User getUserFromIdPass(@Param("username") String username, @Param("password") String password);
	
}
