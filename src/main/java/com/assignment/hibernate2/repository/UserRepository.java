package com.assignment.hibernate2.repository;

import com.assignment.hibernate2.model.User;
import com.assignment.hibernate2.model.UserProfile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	
	public  User findUserById(Long id);

//	public List<User> findAllUsers();

	//11public UserProfile findByUserId(Long id);
	
	
	

}
