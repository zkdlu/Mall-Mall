package com.zkdlu.mnm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zkdlu.mnm.user.model.User;
import com.zkdlu.mnm.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/insert")
	public String insert(@RequestParam("name") String name) {
		userService.save(name);
		return "insert Done";
	}
	
	@GetMapping("/find")
	public List<User> find(@RequestParam("name") String name) {
		return userService.find(name);
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		userService.delete(id);
		return "delete Done";
	}
	
	@GetMapping("users")
	public List<User> findAll() {
		return userService.findAll();
	}
}