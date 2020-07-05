package com.zkdlu.mnm.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zkdlu.mnm.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findById(String id);
	
	@Query("SELECT u from User u where u.id = ?1")
	User findOneById(String id);
	
	@Query("SELECT u from User u where u.id = ?1 and u.passwd = ?2")
	User findOneByIdAndPasswd(String id, String passwd);
}
