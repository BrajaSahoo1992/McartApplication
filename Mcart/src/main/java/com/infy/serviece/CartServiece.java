package com.infy.serviece;

import java.util.List;

import com.infy.entity.Cart;
import com.infy.exception.McartException;

public interface CartServiece {
	public String addCart(Cart cart);
	
	public List<Cart> getAllCarts();
	public Cart getCartDetailsByUserName(String userName) throws McartException;
	public Cart updateCart(Cart cart) throws McartException;

}
