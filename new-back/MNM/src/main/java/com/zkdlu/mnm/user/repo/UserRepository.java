package com.zkdlu.mnm.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zkdlu.mnm.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByName(String name);
}
