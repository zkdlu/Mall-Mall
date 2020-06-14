package com.zkdlu.mnm.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zkdlu.mnm.user.dto.User;

@Repository("userDao")
public class UserDao {
	public List<User> userList() {
		List<User> users = new ArrayList();
		
		User user1 = new User();
		user1.setName("one");
		
		User user2 = new User();
		user2.setName("one");
		
		users.add(user1);
		users.add(user2);
		
		return users;
	}
}
