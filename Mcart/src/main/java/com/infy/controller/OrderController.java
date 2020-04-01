package com.infy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.Order;
import com.infy.exception.McartException;
import com.infy.serviece.OrderServiece;

@RestController
public class OrderController {
	@Autowired
	OrderServiece orderServiece;
	
	@PostMapping("/orders")
	public ResponseEntity<String> createOrders( @RequestBody Order order) throws McartException{
		return new  ResponseEntity<String>(orderServiece.createOrder(order),HttpStatus.OK) ;
		
	}

}
