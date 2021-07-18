package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers(){
		
		return (List<User>) userRepository.findAll();
	}

	public Optional<User> getUserById(Integer id) {
		
		return userRepository.findById(id);
	}

	public List<User> getUsersByLocation(Integer id) {
		
		return userRepository.findByLocationId(id);
	};
	
	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user); 
		
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
		
	}
	

}
