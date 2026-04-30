package com.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDto;
import com.Entity.User;
import com.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/registration")
	public String registration(@RequestBody User u)
	{
		return service.registration(u);
	}
	//ResponseEntity---->set status and body of response
	@PostMapping("/login")
	public ResponseEntity<?>login(@RequestBody UserDto dto)
	{
		User existinguser = service.login(dto);
		if(existinguser!=null)
		{
			return ResponseEntity.ok(existinguser);
		}
		else {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("Invalid username or password");
		}
	}
}