package com.zkdlu.mnm.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zkdlu.mnm.user.dto.UserDTO;
import com.zkdlu.mnm.user.model.User;
import com.zkdlu.mnm.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/join")
	public boolean isOverlapId(@RequestParam("user_id") String id) {
		return userService.isOverlapId(id);
	}
	
	@PostMapping(path = "/join")
	public boolean join(@RequestBody UserDTO userDTO) {
		return userService.join(userDTO);
	}
	
	@PostMapping(path ="/login")
	public boolean login(@RequestBody UserDTO userDTO) {
		String id = userDTO.getUser_id();
		String passwd = userDTO.getPasswd();
		return userService.isMatchUser(id,passwd);
	}
	
	@GetMapping("/users/{user_id}")
	public User view(@PathVariable("user_id") String id) {
		System.out.println(id);
		return userService.view(id);
	}
	
	@PutMapping(path ="/users/{user_id}")
	public boolean edit(@RequestBody UserDTO userDTO, @PathVariable("user_id") String id) {
		if (userDTO.getUser_id().equals(id)) {
			return userService.edit(userDTO);
		}
		return false;
	}
	
	@DeleteMapping(path ="/users/{user_id}")
	public boolean remove(@PathVariable("user_id") String id) {
		return userService.remove(id);
	}
}