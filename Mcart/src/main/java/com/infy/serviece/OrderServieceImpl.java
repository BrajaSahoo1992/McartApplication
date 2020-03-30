package com.infy.serviece;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.entity.Cart;
import com.infy.entity.CartDetails;
import com.infy.entity.Order;
import com.infy.entity.OrderDetails;
import com.infy.exception.McartException;
import com.infy.repository.OrderRepository;

@Service("orderServieceImpl")
public class OrderServieceImpl implements OrderServiece{
	
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	CartServiece serviece;

	@Override
	public String createOrder(Order order) throws McartException {
		Cart cart= serviece.getCartDetailsByUserName(order.getUserName());
		cart.setDateOfModification(new Date());
		cart.setStatusOfCart("closed");
		serviece.addCart(cart);
		order.setCartId(cart.getCartId());
		order.setDateOfOrder(new Date());
		ArrayList<OrderDetails> orderDetails= new  ArrayList<>();
		for(CartDetails cartdetails:cart.getCartDetails()){
			OrderDetails orderDetail= new OrderDetails();
			orderDetail.setProductId(cartdetails.getProductId());
			orderDetail.setProductName(cartdetails.getProductName());
			orderDetail.setQuantity(cartdetails.getQuantity());
			orderDetails.add(orderDetail);
		}
		order.setOrderDetails(orderDetails);
		
		order.getOrderDetails().forEach((activity) -> {
		      activity.setOrder(order);
		   });
		Order orders =orderRepo.saveAndFlush(order);
		if (orders != null){
		return "Now order placed with the ID "+order.getOrderId();
		}
		else{
			throw new McartException("orders not created sucessfully");
			
		}
	}

}
