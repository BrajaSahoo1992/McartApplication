package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infy.entity.Cart;

public interface CartRepository  extends JpaRepository<Cart, Integer>{
	
	@Query(value="select * from CART where user_name=?",nativeQuery=true)
	public Cart getCartDetailsByUserName(String userName);
	
	

}
