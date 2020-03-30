package com.infy.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="Order_Details")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderDetailsId;
	private int productId;
	private String productName;
	private int Quantity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orderId",nullable=false)
	@JsonBackReference
	private Order order;
	public long getOrderId() {
		return orderDetailsId;
	}
	public void setOrderId(long orderId) {
		this.orderDetailsId = orderId;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", productId=" + productId + ", productName="
				+ productName + ", Quantity=" + Quantity + ", order=" + order + "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
    
}
