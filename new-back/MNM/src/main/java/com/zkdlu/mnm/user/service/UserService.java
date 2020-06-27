package com.zkdlu.mnm.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkdlu.mnm.user.dto.UserDTO;
import com.zkdlu.mnm.user.model.User;
import com.zkdlu.mnm.user.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public boolean isOverlapId(String user_id) {
		return userRepo.findOneById(user_id) != null;
	}
	
	public boolean join(UserDTO userDto) {
		User user = new User();
		
		String id = userDto.getUser_id();
		String passwd = userDto.getPasswd();
		int gender = userDto.getGender();
		String phoneNum = userDto.getPhone_number();
		String homeAddress = userDto.getHome_address();
		
		if (id == null || passwd == null
				|| phoneNum == null || homeAddress == null) {
			return false;
		}
		
		user.setId(id);
		user.setPasswd(passwd);
		user.setGender(gender);
		user.setPhoneNum(phoneNum);
		user.setHomeAddress(homeAddress);
		
		try {
			if (!isOverlapId(id)) {
				userRepo.save(user);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean isMatchUser(String user_id, String passwd) {
		User user = userRepo.findOneByIdAndPasswd(user_id, passwd);
		
		return user != null;
	}
}