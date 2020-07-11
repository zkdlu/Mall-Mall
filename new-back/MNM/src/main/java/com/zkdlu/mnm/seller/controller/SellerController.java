package com.zkdlu.mnm.seller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zkdlu.mnm.seller.service.SellerService;
import com.zkdlu.mnm.user.dto.UserDTO;
import com.zkdlu.mnm.user.model.User;
import com.zkdlu.mnm.user.service.UserService;

@RestController
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/seller")
	public boolean getSellerPermission(@RequestBody UserDTO userDTO) {
		String id = userDTO.getUser_id();
		
		return sellerService.addPermission(id);
	}
	
	@GetMapping("/seller/{user_id}")
	public User getSellerInfo(@PathVariable("user_id") String id) {
		return userService.view(id);
	}
}
