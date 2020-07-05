package com.zkdlu.mnm.cart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zkdlu.mnm.cart.model.Cart;
import com.zkdlu.mnm.user.model.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	@Query("SELECT c from Cart c WHERE c.user = ?1")
	List<Cart> findByUser(User user);

}
