package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.UserDto;
import com.Entity.User;
import com.Repository.UserRepository;

@Service
public class UserService {
	@Autowired 
	UserRepository uresp;
	
	public String registration(User u)
	{
		User existinguser = uresp.findByUsername(u.getUsername());
		//if 
		if(existinguser!=null)
		{
			return "This username already exists.Please select another one";
		}
		else {
			uresp.save(u);
			return "Registeration successful";
		}
	}
	
	public User login(UserDto dto)
	{
		User existinguser=uresp.findByUsername(dto.getUsername());
		if(existinguser!=null)
		{
			if(existinguser.getPassword().equals(dto.getPassword()))
			{
				return existinguser;
				
			}
			else {
				return null;
			}
		}
		//if matching record 
		else {
			return null;
		}
	}
}