package com.zkdlu.mnm.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkdlu.mnm.user.model.User;
import com.zkdlu.mnm.user.repo.UserRepository;

@Service
public class SellerService {
	
	@Autowired
	UserRepository userRepo;

	public boolean addPermission(String id) {
		// TODO Auto-generated method stub
		User user = userRepo.findOneById(id);
		if (user != null) {
			user.setSeller(true);
			
			try {
				userRepo.save(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		return false;
	}

}
