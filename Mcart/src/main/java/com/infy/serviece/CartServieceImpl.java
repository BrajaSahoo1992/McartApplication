package com.infy.serviece;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.entity.Cart;
import com.infy.entity.CartDetails;
import com.infy.exception.McartException;
import com.infy.repository.CartRepository;

@Service("cartServieceImpl")
public class CartServieceImpl implements CartServiece {
	
	@Autowired
	CartRepository cartRepo;

	@Override
	public String addCart(Cart cart) {
		cart.setDateOfCretion(new Date());
		cart.setDateOfModification(new Date());
		cart.setStatusOfCart("open");
		cart.getCartDetails().forEach((activity) -> {
		      activity.setCart(cart);
		   });
		Cart cartDetails=cartRepo.saveAndFlush(cart);
		return "Cart added sucessfully for username:"+cartDetails.getUserName();
		
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return cartRepo.findAll();
	}

	@Override
	public Cart getCartDetailsByUserName(String userName) throws McartException {
		Cart cart=cartRepo.getCartDetailsByUserName(userName);
				if(cart!=null){
					return cartRepo.getCartDetailsByUserName(userName);

				}
				else{
					throw new McartException("There is no cart for this"+userName+" user");
				}
			}

	@Override
	public Cart updateCart(Cart cart) throws McartException {
		Cart cartDetails=cartRepo.getCartDetailsByUserName(cart.getUserName());	
		if(cartDetails!=null){
			cartDetails.setDateOfModification(new Date());
			cartDetails.setCartDetails(cart.getCartDetails());
			return cartRepo.save(cartDetails);
		}
		else{
			throw new McartException(cart.getUserName()+" cart is not avialabel");
		}
		
	}

}
