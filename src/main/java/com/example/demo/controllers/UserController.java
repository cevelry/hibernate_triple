package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable Integer id) {
		
		return userService.getUserById(id);
	}
	
	@GetMapping("/user/{id}/posts")
	public List<Post> getPostByUser(@PathVariable Integer id){
		Optional<User> user=userService.getUserById(id);
		if(user.isPresent()) {
			return user.get().getPosts();
		}
		return null;
	}
	
	@GetMapping("users/location/{id}/users")
	public List<User> getUsersByLocation(@PathVariable Integer id){
		return userService.getUsersByLocation(id);
	}
	
	@PostMapping("/users/addNew")
	public void AddUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/users/{id}/update")
	public void UpdateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("/users/{id}/delete")
	public void DeleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
}
