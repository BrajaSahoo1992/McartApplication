package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infy.entity.Cart;
import com.infy.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	
	
}
