package com.zkdlu.mnm.user.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.Param;

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
}