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
	
	public boolean isMatchUser(String user_id, String passwd) {
		User user = userRepo.findOneByIdAndPasswd(user_id, passwd);
		
		return user != null;
	}
	
	public User view (String user_id) {
		List<User> users = userRepo.findById(user_id);
		User user = users.get(0);
		return user;
	}
	
	public boolean edit(UserDTO userDTO) {
		
		String id = userDTO.getUser_id();
		String passwd = userDTO.getPasswd();
		int gender = userDTO.getGender();
		String phoneNum = userDTO.getPhone_number();
		String homeAddress = userDTO.getHome_address();
		
		List<User> users = userRepo.findById(id);
		User user = users.get(0);
		
		//하나 하나 체크해주기보단 전체 값이 완성 되있지 않으면 문제가 있는거니까 한번에 처리하는게 좋아 -> 근데 하나만 바꾸고 심ㅍ을수도 있자나요
		// 그래도 다른 값이 그대로 넘어오니깐 null은 아니지
		//id : 1234
		//pw : 1234
		//phone: 12213234234
		
		//이렇게 있다고 쳐봐??
		//폰번호를 수정 할꺼야.
		//그리고 수정버튼을 눌러
		//그래도 id랑 pw가 같이 넘어오니깐
		//만약에 바뀐 값만 body data에 넣어서 오면 front에서는 어떤 항목이 바뀐건지 추적해야 해서
		//힘들어져 이해가??네네ㅔㄴㅇ
		
		if (id == null || passwd == null
				|| phoneNum == null || homeAddress == null) {
			return false;
		}
		
		user.setPasswd(passwd);
		user.setGender(gender);
		user.setPhoneNum(phoneNum);
		user.setHomeAddress(homeAddress);
		
		//업데이트 할 때 ㄷ시 저장해줘야 한다
		try {
			userRepo.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		//이런식으로
	}
	
	
	public boolean remove(String user_id) {
		List<User> users = userRepo.findById(user_id);
		User user = users.get(0);
		user.setState(1);
		
		try {
			userRepo.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}