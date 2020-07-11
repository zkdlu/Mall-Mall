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
	
	public User authenticate(String id, String passwd) {
		return userRepo.findOneByIdAndPasswd(id, passwd);
	}
	
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
		user.setState(0);
		
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
	
	public User MatchUser(String user_id, String passwd) {
		User user = userRepo.findOneByIdAndPasswd(user_id, passwd);
		
		return user;
	}
	
	public User view (String user_id) {
		User user = userRepo.findOneById(user_id);
		return user;
	}
	
	public boolean edit(UserDTO userDTO) {
		
		String id = userDTO.getUser_id();
		String passwd = userDTO.getPasswd();
		int gender = userDTO.getGender();
		String phoneNum = userDTO.getPhone_number();
		String homeAddress = userDTO.getHome_address();
		
		User user = userRepo.findOneById(id);
		
		if (id == null || passwd == null
				|| phoneNum == null || homeAddress == null) {
			return false;
		}
		
		user.setPasswd(passwd);
		user.setGender(gender);
		user.setPhoneNum(phoneNum);
		user.setHomeAddress(homeAddress);
	
		try {
			userRepo.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean remove(String user_id) {
		User user = userRepo.findOneById(user_id);
		user.setState(1);
		
		try {
			userRepo.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}