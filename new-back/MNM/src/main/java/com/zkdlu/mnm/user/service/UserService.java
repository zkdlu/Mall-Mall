package com.zkdlu.mnm.user.service;

import java.util.List;

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
		return userRepo.findById(user_id).size() != 0; 
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
		try {
			// 1. db에서 user_id와 일치하는 User목록을 가져온다.
			List<User> users = userRepo.findById(user_id);
			
			// 2. User목록이 비어있다면 일치하는 id가 없으니 false 리턴
			if (users.size() == 0) {
				return false;
			}
			
			// 3. id는 중복 되지 않는 컬럼이므로 User목록에는 1개의 값이 들어 있고 0번째 유저 값을 가져온다.
			User user = users.get(0);
			
			// 4. 가져온 유저의 정보(패스워드)와 사용자가 요청한 정보(패스워드)가 일치한지 확인 후 결과를 리턴한다.
			if (user.getPasswd().equals(passwd)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
}