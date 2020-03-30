package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.Cart;
import com.infy.exception.McartException;
import com.infy.serviece.CartServiece;

@RestController
public class CartController {
	
	@Autowired
	CartServiece cartServiece;
	
	@PostMapping("/carts")
	public ResponseEntity<String> addCart(@RequestBody Cart cart){
		return new ResponseEntity<String>(cartServiece.addCart(cart),HttpStatus.OK);
	}
    
	@GetMapping("/carts")
	public ResponseEntity<List<Cart>> getCarts(){
		return new ResponseEntity<List<Cart>>(cartServiece.getAllCarts(),HttpStatus.OK);
	}
	@GetMapping("/carts/{userName}")
	public ResponseEntity<Cart> getCarts(@PathVariable String userName) throws McartException{
		
	return new ResponseEntity<Cart>(cartServiece.getCartDetailsByUserName(userName),HttpStatus.OK);
	}
	@PutMapping("/carts")
	public ResponseEntity<Cart> updateCarts(@RequestBody Cart cart) throws McartException{
		
	return new ResponseEntity<Cart>(cartServiece.updateCart(cart),HttpStatus.OK);
	}
}
