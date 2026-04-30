package com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);
	//registeration : this method check user can not enter same username
	//again and again
	
	//In login,It checks usename already exists or not
	//if yesthen usename valid
}