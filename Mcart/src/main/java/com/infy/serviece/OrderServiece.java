package com.infy.serviece;

import com.infy.entity.Order;
import com.infy.exception.McartException;

public interface OrderServiece {
	public String createOrder(Order order) throws McartException;

}
