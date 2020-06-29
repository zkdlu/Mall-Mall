package com.zkdlu.mnm.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zkdlu.mnm.cart.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
