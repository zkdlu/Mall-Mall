package com.zkdlu.mnm.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkdlu.mnm.user.model.User;
import com.zkdlu.mnm.user.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public List<User> find(String name) {
		return userRepo.findByName(name);
	}
	
	public void save(String name) {
		userRepo.save(new User(name));
	}
	
	public void delete(int id) {
		userRepo.deleteById(id);
	}
}