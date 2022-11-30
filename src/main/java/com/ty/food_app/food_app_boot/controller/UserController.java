package com.ty.food_app.food_app_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.service.UserService;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService service;
	
	
	@PostMapping
	public ResponseStructure<User> saveuser(@RequestBody User user)
	{
		return service.saveUser(user);
	}
	@PutMapping
	public ResponseStructure<User> updateuser(@RequestBody User user,@RequestParam int id)
	{
		return service.updateUser(user, id);
	}
	@GetMapping
	public ResponseStructure<User> getUserById(@RequestParam int id)
	{
		return service.getUserById(id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteUserById(@RequestParam int id)
	{
		return service.deleteUserById(id);
	}

}
