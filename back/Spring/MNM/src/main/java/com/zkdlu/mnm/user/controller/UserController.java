package com.zkdlu.mnm.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkdlu.mnm.user.dto.User;
import com.zkdlu.mnm.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUserList() {
		return userService.getUserList();
	}
}
