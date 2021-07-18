package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {
		return (List<Post>) postRepository.findAll();
	}

	public Optional<Post> findById(Integer id) {
		return postRepository.findById(id);
	}

	public List<Post> getPostsByUser(Integer id) {
		
		return postRepository.findByUserId(id);
	}

	public void addPost(Post post) {
	
		postRepository.save(post);
	}

	public void updatePost(Post post) {
		postRepository.save(post);
		
	}

	public void deletePost(Integer id) {
		postRepository.deleteById(id);
		
	}
	
	
}
